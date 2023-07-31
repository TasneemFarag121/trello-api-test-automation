package apis;

import io.restassured.response.Response;
import oop.GetRequest;
import oop.PostRequest;

public class TrelloApiServer {
public static final String BASE_URI =getEnv();
public static final String API_KEY = "5902747fbf3f5ca974d1c9822575721e";
public static final String API_TOKEN ="ATTAa5601d55d6946cdeba08bea742df69defa169bc7b80db02d4ea1491fddb8f97176ADCFF4";

// EndPoints
public static final String BASE_PATH_Verify_Authentication ="/members/me";
public static final String BASE_PATH_CREATE_BOARD ="/boards";
public static final String BASE_PATH_GET_BOARDS_BELONGS_TO_MEMBER ="/members/me";
public static final String BASE_PATH_DELETE_BOARD ="/boards/{id}";
public static final String BASE_PATH_CREATE_LIST_ON_BOARD ="/boards/{id}/lists";
public static final String BASE_PATH_GET_LISTS_ON_BOARD ="/boards/{id}/lists";
public static final String BASE_PATH_ARCHIVE_UNARCHIVE_LIST_ON_BOARD ="/lists/{id}/closed";



    public static String getEnv(){
        String env = System.getProperty("env" ,"PRODUCTION");
        String baseURL;
        switch (env){

            case "PRODUCTION":
                baseURL = "https://api.trello.com/1";
                break;
            case "LOCAL":
                baseURL = "http://localhost:800";
                break;
            default:
                throw new RuntimeException("Environment is not supported ");
        }
        return baseURL;
    }

    public static Response checkUserAuthentication(){
        GetRequest getRequestToCheckAuthentication = new GetRequest(BASE_URI,BASE_PATH_Verify_Authentication );
        getRequestToCheckAuthentication.addQueryParameter("key",API_KEY);
        getRequestToCheckAuthentication.addQueryParameter("token",API_TOKEN);

        Response response = getRequestToCheckAuthentication.send();


        return response;
    }

}
