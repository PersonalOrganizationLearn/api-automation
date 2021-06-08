package com.automation.api.service;


import com.automation.api.config.Datasource;
import com.automation.api.config.KeyValuePair;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public interface Request {

    Response getApiResponse();

    default RequestSpecification getRequestSpecification(String endpointUrl){
        return RestAssured.given().baseUri(endpointUrl).relaxedHTTPSValidation();
    }

    default Response getCookieAuthentication(Datasource datasource){
        RequestSpecification request = getRequestSpecification(datasource.getLoginEndpoint());
        request.contentType(datasource.getCookieAuth().getContentType());
        for(KeyValuePair data: datasource.getCookieAuth().getFormControlHeaders()){
            if(data.getValue().startsWith("http")){
                try {
                    request.formParam(data.getKey(), URLEncoder.encode(data.getValue(), StandardCharsets.UTF_8.toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                continue;
            }
            request.formParam(data.getKey(), data.getValue());
        }
        return request.when().post(datasource.getLoginResourceUrl());
    }

    default Response getTokenAuthentication(Datasource datasource){
        RequestSpecification request = getRequestSpecification(datasource.getLoginEndpoint());
        request.contentType(ContentType.JSON);
        for(KeyValuePair data: datasource.getTokenAuth().getTokenHeaderList()){
            request.header(new Header(data.getKey(), data.getValue()));
        }
        if(!isNullOrEmpty(datasource.getTokenAuth().getBody())){
            request.body(datasource.getTokenAuth().getBody());
        }
        return request.when().post(datasource.getLoginResourceUrl());
    }

    default boolean isNotNullOrEmpty(Object obj){
        return !isNullOrEmpty(obj);
    }
    default boolean isNullOrEmpty(Object obj){
        return isNull(obj) && isEmpty(obj);
    }

    default boolean isNull(Object obj){
        return obj == null;
    }

    default boolean isEmpty(Object obj){
        return ((String) obj).isEmpty();
    }
}
