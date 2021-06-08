package com.automation.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CookieAuth {
    
    private Map<String, String> cookies;
    private List<KeyValuePair> formControlHeaders;
    private boolean cookieAuth;
    private String cookieName;
    private String contentType;

    public CookieAuth() {
        this.cookieAuth=false;
        this.formControlHeaders = new ArrayList<>();
        this.contentType = "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public String getContentType() {
        return contentType;
    }

    public CookieAuth setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public CookieAuth setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public List<KeyValuePair> getFormControlHeaders() {
        return formControlHeaders;
    }

    public CookieAuth setFormControlHeaders(KeyValuePair... formControlHeaders) {
        for(KeyValuePair formControlHeader: formControlHeaders)
            this.formControlHeaders.add(formControlHeader);
        return this;
    }

    public boolean isCookieAuth() {
        return this.formControlHeaders.size()>0;
    }

    public String getCookieName() {
        return cookieName;
    }

    public CookieAuth setCookieName(String cookieName) {
        this.cookieName = cookieName;
        return this;
    }
}
