package com.automation.api.service.impl;

import com.automation.api.config.Datasource;
import com.automation.api.exception.ApiException;
import com.automation.api.service.RequestProcessing;
import io.restassured.response.Response;

public class DeleteRequest extends RequestProcessing {
    public DeleteRequest(Datasource datasource, String body) {
        super(datasource, body);
        this.getRequest();
    }

    @Override
    public Response getApiResponse() {
        try{
            this.getBody();
            return this.request.delete(this.datasource.getResourceUtl());
        }catch (Exception e){
            if((!this.datasource.getCookieAuth().isCookieAuth()) || (!this.datasource.getTokenAuth().isTokenAuth()))
                throw new ApiException("Login might be required, Please use data source class to pass the necessary information");
            throw new ApiException("Un-expected exception caught");
        }
    }
}
