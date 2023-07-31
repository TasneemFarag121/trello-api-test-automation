package apis;

import io.restassured.response.Response;
import oop.GetRequest;
import oop.PostRequest;
import oop.PutRequest;

public class ListApi {

    public static Response createListOnBoard(String boardId , String listName){
        PostRequest createListOnBoard = new PostRequest(TrelloApiServer.BASE_URI,TrelloApiServer.BASE_PATH_CREATE_LIST_ON_BOARD);
        createListOnBoard.addHeader("Accept","application/json");
        createListOnBoard.addPathParameter("id",boardId);
        createListOnBoard.addQueryParameter("name",listName);
        createListOnBoard.addQueryParameter("key", TrelloApiServer.API_KEY);
        createListOnBoard.addQueryParameter("token" ,TrelloApiServer.API_TOKEN);

        Response response = createListOnBoard.send();
        return response;

    }

    public static Response getListsOnBoard(String boardId ){
        GetRequest getListOnBoard = new GetRequest(TrelloApiServer.BASE_URI,TrelloApiServer.BASE_PATH_GET_LISTS_ON_BOARD);
        getListOnBoard.addHeader("Accept","application/json");
        getListOnBoard.addPathParameter("id",boardId);
        getListOnBoard.addQueryParameter("key", TrelloApiServer.API_KEY);
        getListOnBoard.addQueryParameter("token" ,TrelloApiServer.API_TOKEN);

        Response response = getListOnBoard.send();
        return response;

    }

    public static Response archiveListOnBoard(String listID){
        PutRequest archiveListOnBoard = new PutRequest(TrelloApiServer.BASE_URI,TrelloApiServer.BASE_PATH_ARCHIVE_UNARCHIVE_LIST_ON_BOARD);
        archiveListOnBoard.addHeader("Accept","application/json; charset=utf-8");
        archiveListOnBoard.addPathParameter("id",listID);
        archiveListOnBoard.addQueryParameter("key", TrelloApiServer.API_KEY);
        archiveListOnBoard.addQueryParameter("token" ,TrelloApiServer.API_TOKEN);
        archiveListOnBoard.addQueryParameter("value","true");

        Response response = archiveListOnBoard.send();
        return response;

    }
    public static Response unArchiveListOnBoard(String listID){
        PutRequest unArchiveListOnBoard = new PutRequest(TrelloApiServer.BASE_URI,TrelloApiServer.BASE_PATH_ARCHIVE_UNARCHIVE_LIST_ON_BOARD);
        unArchiveListOnBoard.addHeader("Accept","application/json; charset=utf-8");
        unArchiveListOnBoard.addPathParameter("id",listID);
        unArchiveListOnBoard.addQueryParameter("key", TrelloApiServer.API_KEY);
        unArchiveListOnBoard.addQueryParameter("token" ,TrelloApiServer.API_TOKEN);
        unArchiveListOnBoard.addQueryParameter("value","false");

        Response response = unArchiveListOnBoard.send();
        return response;

    }


}
