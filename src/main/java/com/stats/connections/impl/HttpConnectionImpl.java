package com.stats.connections.impl;

import com.stats.connections.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.apache.http.HttpHeaders.USER_AGENT;

@Component
public class HttpConnectionImpl implements HttpConnection {
    @Override
    public JSONObject get(String path, String params) {
        HttpResponse response = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            URIBuilder builder = new URIBuilder(path);
            builder.setParameter("sql", params);
            HttpGet request = new HttpGet(builder.build());
            request.addHeader("User-Agent", USER_AGENT);
            response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseResponse(response);
    }

    @Override
    public JSONObject parseResponse(HttpResponse response) {
        JSONObject json = null;
        try {
            BufferedReader rd  = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            json = new JSONObject(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
