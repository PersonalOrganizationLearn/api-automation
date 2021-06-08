package com.automation.api;

import com.automation.api.config.Datasource;
import com.automation.api.constant.RequestType;
import com.automation.api.service.Request;
import com.automation.api.service.impl.DeleteRequest;
import com.automation.api.service.impl.GetRequest;
import com.automation.api.service.impl.PostRequest;
import com.automation.api.service.impl.PullRequest;

public final class Api {

    private RequestType type;
    private Request request;
    private Datasource datasource;

    public Api(RequestType type, Datasource datasource) {
        this.type = type;
        this.datasource = datasource;
    }

    private void getRequest(String body){
        if(this.type == RequestType.GET)
            this.request = new GetRequest(datasource);
        if(this.type == RequestType.POST)
            this.request = new PostRequest(datasource, body);
        if(this.type == RequestType.PUT)
            this.request = new PullRequest(datasource, body);
        if(this.type == RequestType.DELETE)
            this.request = new DeleteRequest(datasource, body);
    }
}
