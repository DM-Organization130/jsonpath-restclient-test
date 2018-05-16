package jsonpathrestclienttest.jsonpathrestclienttest.controller;

import com.google.gson.Gson;
import jsonpathrestclienttest.jsonpathrestclienttest.ServiceCall;
import jsonpathrestclienttest.jsonpathrestclienttest.models.SourceQueryOption;
import jsonpathrestclienttest.jsonpathrestclienttest.models.WeatherHeadline;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    public List<WeatherHeadline> GetForecasts()
    {
        SourceQueryOption sourceQueryOption = new SourceQueryOption();
        ServiceCall serviceCall = new ServiceCall();

        String Url ="https://api.darksky.net/forecast/5b3ae7e480d380ab63d07663e4b7a423/37.8267,-122.4233";
        String responsePath = "$.daily.data[*]";

        Gson gson = new Gson();
        HashMap<String, String> hmap = (HashMap<String, String>) gson.fromJson(sourceQueryOption.getResponseMapping(), HashMap.class);

        serviceCall.RestGet(Url, responsePath, hmap);

        return null;

    }




}