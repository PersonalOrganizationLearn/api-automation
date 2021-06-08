package com.automation.api.constant;

public enum RequestType {
    GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");

    private String requestType;
    RequestType(String requestType){
        this.requestType = requestType;
    }

    public String getRequestType() {
        return this.requestType;
    }
}
