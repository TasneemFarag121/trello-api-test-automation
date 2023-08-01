package oop;

import io.restassured.response.Response;;
public class GetRequest extends ApiRequest {

    public GetRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }

    public Response send(){
        return request.get();

    }




}
