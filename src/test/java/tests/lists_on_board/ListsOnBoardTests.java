package tests.lists_on_board;

import apis.BoardApi;
import apis.ListApi;
import io.restassured.response.Response;
import models.board_list.BoardList;
import org.testng.annotations.Test;
import testdata.TestData_Board;
import testdata.TestData_ListOnBoard;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class ListsOnBoardTests {
    String boardId;

    @Test
    public void testCreateListOnBoard(){
        String boardId = TestData_Board.getCreatedBoardID();
        String listName= TestData_ListOnBoard.getRandomListName();
        Response response = ListApi.createListOnBoard(boardId,listName);
        response.prettyPrint();

        System.out.println("BoardId : "+ boardId);
        System.out.println("ListName : "+ listName);
        assertThat(response.statusCode() ,equalTo(200));

        // Assertion using Json response
        assertThat(response.body().path("$"),hasKey("id"));
        assertThat(response.body().path("$"),hasKey("name"));
        assertThat(response.body().path("$"),hasKey("idBoard"));
        assertThat(response.body().path("closed"),equalTo(false));
        assertThat(response.body().path("limits").toString(), equalTo("{}"));

        // Deserialization
        BoardList boardList = response.body().as(BoardList.class);

        // Assertion using Deserialized Object
        assertThat(boardList,hasProperty("id"));
        assertThat(boardList.getClosed(),equalTo(false));
        assertThat(boardList.getLimits().toString(), equalTo("{}"));


        BoardApi.deleteBoard(boardId);


    }

    @Test
    public void testGetListsOnBoard(){
        String boardId = TestData_Board.getCreatedBoardID();
        Response response = ListApi.getListsOnBoard(boardId);

        assertThat(response.statusCode() ,equalTo(200));

        List<BoardList> listsOnBoard = response.body().as(List.class);

        assertThat(listsOnBoard.size() ,equalTo(3));
        BoardApi.deleteBoard(boardId);
    }

    @Test
    public void testArchiveList(){
        // Test Data Preparation
        String boardId = TestData_Board.getCreatedBoardID();
        String listId = TestData_ListOnBoard.getCreatedListID(boardId);

        // Test
        Response response = ListApi.archiveListOnBoard(listId);
        response.prettyPrint();

        // Response Assertion
        assertThat(response.statusCode() ,equalTo(200));
        assertThat(response.body().path("closed"),equalTo(true));
        assertThat(response.header("Set-Cookie"),containsString("isEnterpriseAdmin%3Dfalse"));

        //Deserilization
        BoardList returnedResponse = response.body().as(BoardList.class);
        assertEquals(returnedResponse.getClosed(),true);

        //Delete Test Data
        BoardApi.deleteBoard(boardId);


    }
    @Test
    public void testUnArchiveList(){
        String boardId = TestData_Board.getCreatedBoardID();
        String listId = TestData_ListOnBoard.getCreatedListID(boardId);
        Response response = ListApi.unArchiveListOnBoard(listId);
        response.prettyPrint();
        assertThat(response.statusCode() ,equalTo(200));
        assertThat(response.body().path("closed"),equalTo(false));
        assertThat(response.header("Set-Cookie"),containsString("isEnterpriseAdmin%3Dfalse"));

        BoardList returnedResponse = response.body().as(BoardList.class);
        assertEquals(returnedResponse.getClosed(),false);
        BoardApi.deleteBoard(boardId);

    }
}
