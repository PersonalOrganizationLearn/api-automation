package com.automation.api.config;

import io.restassured.http.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Datasource {

    private String loginEndpoint;
    private String loginResourceUrl;
    private String endpoint;
    private String resourceUtl;
    private List<Header> headers;
    private Map<String, String> queryStrings;
    private CookieAuth cookieAuth;
    private TokenAuth tokenAuth;

    public Datasource(String endpoint, String resourceUtl) {
        this.endpoint = endpoint;
        this.resourceUtl = resourceUtl;
        this.cookieAuth = new CookieAuth();
        this.tokenAuth = new TokenAuth();
        this.headers = new ArrayList<>();
    }

    public String getLoginEndpoint() {
        return loginEndpoint;
    }

    public Datasource setLoginEndpoint(String loginEndpoint) {
        this.loginEndpoint = loginEndpoint;
        return this;
    }

    public String getLoginResourceUrl() {
        return loginResourceUrl;
    }

    public Datasource setLoginResourceUrl(String loginResourceUrl) {
        this.loginResourceUrl = loginResourceUrl;
        return this;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Datasource setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getResourceUtl() {
        return resourceUtl;
    }

    public Datasource setResourceUtl(String resourceUtl) {
        this.resourceUtl = resourceUtl;
        return this;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public Datasource setHeaders(Header... headers) {
        for(Header header: headers){
            this.headers.add(header);
        }
        return this;
    }

    public Map<String, String> getQueryStrings() {
        return queryStrings;
    }

    public Datasource setQueryStrings(Map<String, String> queryStrings) {
        this.queryStrings = queryStrings;
        return this;
    }

    public CookieAuth getCookieAuth() {
        return cookieAuth;
    }

    public Datasource setCookieAuth(CookieAuth cookieAuth) {
        this.cookieAuth = cookieAuth;
        return this;
    }

    public TokenAuth getTokenAuth() {
        return tokenAuth;
    }

    public Datasource setTokenAuth(TokenAuth tokenAuth) {
        this.tokenAuth = tokenAuth;
        return this;
    }
}
