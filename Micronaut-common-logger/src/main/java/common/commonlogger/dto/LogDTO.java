package common.commonlogger.dto;

import common.commonlogger.utils.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDTO {
    private String eventType;
    private String method;
    private Map<String, List<String>> headers;
    private Object payload;
    private Object queryParams;
    private Object pathParams;
    private String uri;
    private String statusResponse;

    public Map<String, Object> logData() {
        Map<String, Object> logData = new HashMap<>();
        logData.put("eventType", this.eventType);
        logData.put("header", this.headers);
        logData.put("payload", this.payload);
        logData.put("queryParameters", this.queryParams);
        logData.put("pathParameters", this.pathParams);
        logData.put("method", this.method);
        logData.put("uri", this.uri);
        logData.put("status", this.statusResponse);
        return logData;

    }

    public String toJson() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter()).create();
        return gson.toJson(this);
    }

}

