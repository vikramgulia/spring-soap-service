package com.example.demo;

import javax.jws.WebService;

import org.apache.cxf.annotations.SchemaValidation;

import namespace.getweatherservice._new.DegreeType;
import namespace.getweatherservice._new.GetWeatherPortType;
import namespace.getweatherservice._new.GetWeatherRequest;
import namespace.getweatherservice._new.GetWeatherResponse;
import namespace.getweatherservice._new.ObjectFactory;

@WebService(
    serviceName = "GetWeatherService", 
    portName = "GetWeatherPortType", 
    targetNamespace = "http://new.getWeatherService.namespace", 
    endpointInterface = "namespace.getweatherservice._new.GetWeatherPortType",
    wsdlLocation = "classpath:wsdl/GetWeather.wsdl")
@SchemaValidation
public class GetWeather implements GetWeatherPortType {
    private static final String[] STRINGS = { "Ohh, its gonna rain today", "Damn, it going to be so hot",
            "Snow, Snow, Snow, Snow", "Sunny with chances of rain showers", "Windy City Windy", "Clear Sky",
            "Go for picnic kinda weather" };
    private static int count = 0;

    @Override
    public GetWeatherResponse getWeather(GetWeatherRequest getWeatherRequest) {
        DegreeType type = DegreeType.FARENHEIT;
        if(getWeatherRequest.getDegree() == DegreeType.CELSIUS){
            type = DegreeType.CELSIUS;
        }

        System.out.println(getWeatherRequest.getZipcode());
        GetWeatherResponse getWeatherResponse = new ObjectFactory().createGetWeatherResponse();
        getWeatherResponse.setCity("parker");
        getWeatherResponse.setWeather(STRINGS[count++ % STRINGS.length]);
        getWeatherResponse.setTemp("100"+type.name());
        return getWeatherResponse;
    }

}
