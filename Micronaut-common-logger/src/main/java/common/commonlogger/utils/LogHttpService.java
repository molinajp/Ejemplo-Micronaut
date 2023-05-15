package common.commonlogger.utils;

import common.commonlogger.service.LoggingService;
import jakarta.inject.Singleton;

@Singleton
public class LogHttpService extends LogServiceAbstract {

    public LogHttpService(LoggingService loggingService) {
        super(loggingService);
    }
}
