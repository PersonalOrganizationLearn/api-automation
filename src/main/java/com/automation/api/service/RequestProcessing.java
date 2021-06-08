package com.automation.api.service;

import com.automation.api.config.Datasource;

public abstract class RequestProcessing extends Login{
    private String body;
    public RequestProcessing(Datasource datasource, String body) {
        super(datasource);
        this.body = body;
    }

    public void getBody() {
        if(isNotNullOrEmpty(this.body))
            this.request.body(this.body);
    }
}
