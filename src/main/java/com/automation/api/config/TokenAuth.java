package com.automation.api.config;

import java.util.ArrayList;
import java.util.List;

public class TokenAuth {
    
    private boolean tokenAuth;
    private List<KeyValuePair> tokenHeaderList;
    private String tokenPath;
    private String token;
    private String tokenKey;
    private String tokenAppender;
    private String body;

    public TokenAuth() {
        this.tokenAuth = false;
        this.tokenHeaderList = new ArrayList<>();
    }

    public boolean isTokenAuth() {
        return this.tokenHeaderList.size()>0;
    }

    public List<KeyValuePair> getTokenHeaderList() {
        return tokenHeaderList;
    }

    public TokenAuth setTokenHeaderList(List<KeyValuePair> tokenHeaderList) {
        this.tokenHeaderList = tokenHeaderList;
        return this;
    }

    public String getTokenPath() {
        return tokenPath;
    }

    public TokenAuth setTokenPath(String tokenPath) {
        this.tokenPath = tokenPath;
        return this;
    }

    public String getToken() {
        return token;
    }

    public TokenAuth setToken(String token) {
        this.token = token;
        return this;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public TokenAuth setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
        return this;
    }

    public String getTokenAppender() {
        return tokenAppender;
    }

    public TokenAuth setTokenAppender(String tokenAppender) {
        this.tokenAppender = tokenAppender;
        return this;
    }

    public String getBody() {
        return body;
    }

    public TokenAuth setBody(String body) {
        this.body = body;
        return this;
    }
}
