package jsonpathrestclienttest.jsonpathrestclienttest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jayway.jsonpath.JsonPath;
import jsonpathrestclienttest.jsonpathrestclienttest.models.WeatherDetail;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.svenson.JSONParser;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ServiceCall {
    public ArrayList RestGet(String url, String responsePath, HashMap<String,String> hm)
    {
        org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {


            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            for (String key: hm.keySet()
                    ) {
                content = content.replace(hm.get(key), key);
            }

            List<LinkedHashMap> authors = JsonPath.read(content, responsePath);

            for (LinkedHashMap s: authors)
            {
                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(s);
                WeatherDetail wd = gson.fromJson(jsonElement, WeatherDetail.class);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
