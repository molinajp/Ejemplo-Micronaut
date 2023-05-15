package com.example.errorhandler;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.server.exceptions.response.ErrorContext;
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor;
import jakarta.inject.Singleton;

@Singleton
public class RestExceptionHandler implements ErrorResponseProcessor<APIError> {

    @Override
    public MutableHttpResponse<APIError> processResponse(@NonNull ErrorContext errorContext,
            @NonNull MutableHttpResponse<?> response) {
        APIError apiError;
        if (!errorContext.hasErrors()) {
            apiError = new APIError(response.getStatus().getCode(), "No custom errors found...");
        } else {
            var firstError = errorContext.getErrors().get(0);
            apiError = new APIError(response.getStatus().getCode(), firstError.getMessage());
        }
        return response.body(apiError);
    }
}
