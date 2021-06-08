package com.automation.api.service.impl;

import com.automation.api.config.Datasource;
import com.automation.api.service.Login;
import io.restassured.response.Response;

public class GetRequest extends Login {
    public GetRequest(Datasource datasource) {
        super(datasource);
    }

    @Override
    public Response getApiResponse() {
        return this.request.get(this.datasource.getResourceUtl());
    }
}
