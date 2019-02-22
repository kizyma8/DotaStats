package com.stats.connections;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface HttpConnection {

    public JSONObject get(String path, String params);

    public JSONObject parseResponse(HttpResponse response);
}
