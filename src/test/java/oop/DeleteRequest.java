package oop;

import io.restassured.response.Response;

public class DeleteRequest extends ApiRequest{
    public DeleteRequest(String baseUri , String basePath){

        super(baseUri,basePath);

    }

    public Response send(){
        return request.delete();

    }

}
