package common.commonlogger.filter;

import common.commonlogger.utils.LogClientService;
import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;

import java.util.Optional;

@Filter("/**")
public class FilterForClient implements HttpClientFilter {

    private final LogClientService traceService;

    private static final String REQUEST_EVENT_TYPE = "Client Request";
    private static final String RESPONSE_EVENT_TYPE = "Client Response";

    public FilterForClient(LogClientService traceService) { // (3)
        this.traceService = traceService;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        return Flowable.fromPublisher(chain.proceed(request))
                .doOnNext(res -> {
                    Optional<String> body = ServerRequestContext.currentRequest().get().getBody(String.class);
                    traceService.logRequest(request, body, REQUEST_EVENT_TYPE);
                    traceService.logResponse(res, RESPONSE_EVENT_TYPE);
                });
    }
}
