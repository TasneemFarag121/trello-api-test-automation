package oop;

import io.restassured.response.Response;

public class PostRequest extends ApiRequest{

    public PostRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }

    public void addFormParameter(String parameter , String value){
        request.formParam(parameter, value);

    }

    @Override
    public Response send(){
        return request.post();

    }

}
