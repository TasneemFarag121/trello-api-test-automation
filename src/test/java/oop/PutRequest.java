package oop;

import io.restassured.response.Response;

public class PutRequest extends ApiRequest {


    public PutRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }

    public void addFormParameter(String parameter , String value){
        request.formParam(parameter, value);

    }

    public Response send(){
        return request.put();

    }


}
