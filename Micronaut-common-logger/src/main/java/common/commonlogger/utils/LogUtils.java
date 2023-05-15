package common.commonlogger.utils;

import common.commonlogger.dto.LogDTO;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LogUtils {

    private LogUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String createDocId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String text) {
        return (text == null || text.isEmpty());
    }

    public static String getJsonMessage(String msg, String messagefield, String extrafields) {
        JSONObject jsonmsg = null;
        String response;
        try {
            jsonmsg = new JSONObject().put(messagefield, msg);

            response = addExtraFields(jsonmsg, extrafields).toString();
        } catch (Exception e) {
            response = null;
        }
        return response;
    }

    public static String getJsonMessage(String msg, String extrafields) {
        JSONObject jsonmsg = null;
        String response;
        try {
            jsonmsg = new JSONObject(msg);

            response = addExtraFields(jsonmsg, extrafields).toString();
        } catch (Exception e) {
            response = null;
        }
        return response;
    }

    private static JSONObject addExtraFields(JSONObject jsonmsg, String extrafields) {
        if (!isNullOrEmpty(extrafields)) {
            for (String field : extrafields.split(",")) {
                jsonmsg.put(field.split("=")[0], field.split("=")[1]);
            }
        }
        return jsonmsg;
    }

    public static LogDTO format(Map<String, List<String>> headers, Object body, Map<String, String[]> queryParameters) {
        var log = new LogDTO();
        log.setPayload(body);
        log.setQueryParams(queryParameters);
        log.setHeaders(headers);
        return log;
    }
}
