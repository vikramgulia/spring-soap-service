package com.example.demo;

import namespace.getweatherservice._new.GetWeatherRequest;
import namespace.getweatherservice._new.GetWeatherResponse;
import namespace.getweatherservice._new.ObjectFactory;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetWeather {
    private static final String[] STRINGS = { "Ohh, its gonna rain today", "Damn, it going to be so hot",
            "Snow, Snow, Snow, Snow", "Sunny with chances of rain showers", "Windy City Windy", "Clear Sky",
            "Go for picnic kinda weather" };
    private static final String NAMESPACE_URI = "http://new.getWeatherService.namespace";
    private static int count = 0;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWeatherRequest")
    public GetWeatherResponse createOrder(@RequestPayload GetWeatherRequest getWeatherRequest) throws Exception {
        if(getWeatherRequest.getZipcode().length() < 5){
            throw new Exception("ZipCode cannot be less than 5 digits");
        }
        System.out.println(getWeatherRequest.getCity());
        System.out.println(getWeatherRequest.getZipcode());
        GetWeatherResponse getWeatherResponse = new ObjectFactory().createGetWeatherResponse();
        getWeatherResponse.setCity(getWeatherRequest.getCity());
        getWeatherResponse.setWeather(STRINGS[count++ % STRINGS.length]);
        return getWeatherResponse;
    }

}