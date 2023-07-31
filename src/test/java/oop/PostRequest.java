package oop;

import io.restassured.response.Response;

public class PostRequest extends ApiRequest{

    public PostRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }

    public void addFormParameter(String parameter , String value){
        request.formParam(parameter, value);

    }
    // [Q]
    //    public void addBody(String parameter , String value){
//        request.queryParam(parameter, value);
//
//    }


    public Response send(){
        return request.post();

    }

}
