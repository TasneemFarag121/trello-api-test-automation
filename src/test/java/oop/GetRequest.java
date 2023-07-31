package oop;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetRequest extends ApiRequest {

    public GetRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }
    //[Q]
//    public void addQueryParameter(String parameter , String value){
//        request.queryParam(parameter, value);
//
//    }

    public Response send(){
        return request.get();

    }




}
