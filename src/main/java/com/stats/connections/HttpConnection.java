package com.stats.connections;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

import java.util.Map;

public interface HttpConnection {

    public JSONObject get(String path, String params);

    public JSONObject parseResponse(HttpResponse response);
}
