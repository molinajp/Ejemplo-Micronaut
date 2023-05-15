package common.commonlogger.utils;

import common.commonlogger.service.LoggingService;
import jakarta.inject.Singleton;

@Singleton
public class LogClientService extends LogServiceAbstract {

    public LogClientService(LoggingService loggingService) {
        super(loggingService);
    }
}
