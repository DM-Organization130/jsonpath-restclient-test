package jsonpathrestclienttest.jsonpathrestclienttest;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.svenson.JSONParser;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceCall {
    public ArrayList RestGet(String url, String responsePath, HashMap<String,String> hm)
    {
        org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://" + url);
        try {


            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            JSONParser parser = new JSONParser();



            for (String key: hm.keySet()
                    ) {
                content = content.replace(hm.get(key), key);
            }

            List<String> authors = JsonPath.read(content, "$.store.book[*].author");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
