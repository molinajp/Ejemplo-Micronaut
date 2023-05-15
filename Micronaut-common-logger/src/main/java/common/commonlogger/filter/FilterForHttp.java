package common.commonlogger.filter;

import common.commonlogger.utils.LogHttpService;
import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

import java.util.Optional;

@Filter("/**")
@Slf4j
public class FilterForHttp implements HttpServerFilter {

    private final LogHttpService traceService;

    private static final String REQUEST_EVENT_TYPE = "Request";
    private static final String RESPONSE_EVENT_TYPE = "Response";

    public FilterForHttp(LogHttpService traceService) { // (3)
        this.traceService = traceService;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {

        return Flowable.fromPublisher(chain.proceed(request))
                .doOnNext(res -> {
                    Optional<String> body = ServerRequestContext.currentRequest().get().getBody(String.class);
                    traceService.logRequest(request, body, REQUEST_EVENT_TYPE);
                    traceService.logResponse(res, RESPONSE_EVENT_TYPE);
                });
    }
}


