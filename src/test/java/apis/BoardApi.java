package apis;

import io.restassured.response.Response;
import oop.DeleteRequest;
import oop.GetRequest;
import oop.PostRequest;

public class BoardApi {

    public static Response createBoard (String boardName){


        PostRequest createBoardRequest = new PostRequest(TrelloApiServer.BASE_URI ,TrelloApiServer.BASE_PATH_CREATE_BOARD);
        createBoardRequest.addQueryParameter("name" ,boardName);
        createBoardRequest.addQueryParameter("key" ,TrelloApiServer.API_KEY);
        createBoardRequest.addQueryParameter("token" ,TrelloApiServer.API_TOKEN);

        Response response = createBoardRequest.send();

        return response;


    }

    public static Response getBoardsBelongsToMember (){
        GetRequest getBoards = new GetRequest(TrelloApiServer.BASE_URI,TrelloApiServer.BASE_PATH_GET_BOARDS_BELONGS_TO_MEMBER);
        getBoards.addQueryParameter("boards","open");
        getBoards.addQueryParameter("key", TrelloApiServer.API_KEY);
        getBoards.addQueryParameter("token",TrelloApiServer.API_TOKEN);
        Response response = getBoards.send();

        return  response;

    }

    public static Response deleteBoard(String boardID){


        DeleteRequest deleteBoardRequest= new DeleteRequest(TrelloApiServer.BASE_URI ,TrelloApiServer.BASE_PATH_DELETE_BOARD);
        deleteBoardRequest.addHeader("Accept","application/json");
        deleteBoardRequest.addPathParameter("id",boardID);
        deleteBoardRequest.addQueryParameter("key",TrelloApiServer.API_KEY );
        deleteBoardRequest.addQueryParameter("token",TrelloApiServer.API_TOKEN );

        Response response = deleteBoardRequest.send();
        return response;
    }



}
