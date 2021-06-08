package com.automation.api.service;

import com.automation.api.config.CookieAuth;
import com.automation.api.config.Datasource;
import com.automation.api.config.TokenAuth;
import com.automation.api.exception.ApiException;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Map;

public abstract class Login implements Request{

    public Datasource datasource;
    public RequestSpecification request;
    public Login(Datasource datasource) {
        this.datasource = datasource;
    }

    private void getQueryParameter(Map<String, String> queryStrings){
        if(queryStrings != null && queryStrings.keySet().size()>0)
            this.request.queryParams(queryStrings);
    }

    private void getApiCookies(){
        this.datasource.getCookieAuth().setCookies(
                this.getCookieAuthentication(this.datasource).getCookies());
    }

    private void getToken() {
        Response response = this.getTokenAuthentication(this.datasource);
        int code = response.getStatusCode();
        if(code == HttpStatus.SC_OK ||
                code == HttpStatus.SC_ACCEPTED
                || code == HttpStatus.SC_CREATED){
            this.datasource.getTokenAuth().setToken(
                    JsonPath.parse(response.getBody().asString()).read(
                            this.datasource.getTokenAuth().getTokenPath()
                    )
            );
            return;
        }
        this.datasource.getTokenAuth().setToken(null);
    }

    public void getRequest(){
        request = this.getRequestSpecification(datasource.getEndpoint());
        if(datasource.getCookieAuth().isCookieAuth()){
            this.getApiCookies();
            CookieAuth cookieAuth = this.datasource.getCookieAuth();
            if(cookieAuth.getCookies().get(cookieAuth.getCookieName()) == null)
                throw new ApiException("Login is failed, Unable to find cookie named " + cookieAuth.getCookieName() );
            request.cookies(cookieAuth.getCookies());
        }
        if(datasource.getTokenAuth().isTokenAuth()){
            this.getToken();
            TokenAuth tokenAuth = this.datasource.getTokenAuth();
            if(isNullOrEmpty(tokenAuth.getToken()))
                throw new ApiException("Login is failed, Unable to find token named " + tokenAuth.getTokenPath() );
            request.header(new Header(tokenAuth.getTokenKey(),
                    tokenAuth.getTokenAppender() + tokenAuth.getToken()));
        }
        request.contentType(ContentType.JSON);
        getQueryParameter(this.datasource.getQueryStrings());
    }


}
