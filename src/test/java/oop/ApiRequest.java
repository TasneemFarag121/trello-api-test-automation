package oop;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class ApiRequest {

    public String baseUri;
    public String basePath;
    RequestSpecification request;

    public ApiRequest(String baseUri , String basePath){
        this.baseUri = baseUri;
        this.basePath = basePath;
        request = RestAssured.given().baseUri(baseUri).basePath(basePath).contentType(ContentType.JSON);
    }


    public void addQueryParameter(String parameter , String value){
        request.queryParam(parameter, value);

    }

    public void addPathParameter(String parameter , String value){
        request.pathParam(parameter, value);

    }


    public void addHeader(String header , String value){
        request.header(header ,value);
    }

    public abstract Response send();


}
