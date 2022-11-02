package tracksAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tracksAPI.model.RawResponse;
import tracksAPI.model.Response;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Utils {
    public static RawResponse getRequest(String inputURL) throws Exception {

        RawResponse r = new RawResponse();

        StringBuilder result = new StringBuilder();
        URL url = new URL(inputURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        long start = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        long finish = System.currentTimeMillis();

        Gson gson = new GsonBuilder().create();
        Response response = gson.fromJson(result.toString(), Response.class);


        r.date = conn.getHeaderField("Date");
        r.setResponseTimeMs(finish - start);
        r.setResponse(response);
        r.setResponseCode(conn.getResponseCode());

        return r;
    }
}
