package common.commonlogger.utils;

import common.commonlogger.dto.LogDTO;
import common.commonlogger.service.LoggingService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class LogServiceAbstract {

    private final LoggingService loggingService;

    public void logRequest(HttpRequest<?> request, Optional<String> body, String eventType) {
        LogDTO logDTO = LogDTO.builder().uri(request.getUri().toString()).eventType(eventType)
                .headers(request.getHeaders().asMap()).method(request.getMethodName())
                .payload(body.orElse(null)).pathParams(request.getParameters()).build();
        loggingService.logData(logDTO);
    }

    public void logResponse(HttpResponse<?> response, String eventType) {
        LogDTO logDTO = LogDTO.builder().eventType(eventType).headers(response.getHeaders().asMap())
                .payload(response.getBody().isPresent() ? response.getBody().get() : null)
                .statusResponse(response.getStatus().getCode() + " " + response.getStatus().toString()).build();
        loggingService.logData(logDTO);
    }

}
