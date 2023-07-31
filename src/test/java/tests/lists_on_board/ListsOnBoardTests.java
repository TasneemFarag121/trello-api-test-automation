package tests.lists_on_board;

import apis.BoardApi;
import apis.ListApi;
import io.restassured.response.Response;
import models.ListOnBoard;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import testdata.TestData_Board;
import testdata.TestData_ListOnBoard;

import static io.restassured.RestAssured.given;
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

        // Cannot parse object because no supported Content-Type was specified in response. Content-Type was 'text/plain; charset=utf-8'.
        // ListOnBoard returnedResponse = response.body().as(ListOnBoard.class);
        System.out.println("BoardId : "+ boardId);
        System.out.println("ListName : "+ listName);

        assertThat(response.statusCode() ,equalTo(200));
        assertThat(response.body().path("$"),hasKey("id"));
        assertThat(response.body().path("$"),hasKey("name"));
        assertThat(response.body().path("$"),hasKey("idBoard"));
        assertThat(response.body().path("closed"),equalTo(false));
        assertThat(response.body().path("limits"), Matchers.notNullValue());
        //List<Limit> limits = objectMapper.readValue(response.body().path("limits"), new TypeReference<List<Limit>>() {});
        //assertThat(limits, contains(empty()));
        //assertThat((response.body().path("limits")),Matchers.hasSize(-));

        BoardApi.deleteBoard(boardId);


    }

    @Test
    public void testGetListsOnBoard(){
        String boardId = TestData_Board.getCreatedBoardID();
        Response response = ListApi.getListsOnBoard(boardId);

        assertThat(response.statusCode() ,equalTo(200));
        assertThat(response.body().path("$"),hasSize(3));

//        ListOnBoard returnedResponse = response.body().as(ListOnBoard.class);
//        assertThat(returnedResponse.getListsOnBoard().size() ,equalTo(3));
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
        ListOnBoard returnedResponse = response.body().as(ListOnBoard.class);
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

        ListOnBoard returnedResponse = response.body().as(ListOnBoard.class);
        assertEquals(returnedResponse.getClosed(),false);
        BoardApi.deleteBoard(boardId);

    }
}
