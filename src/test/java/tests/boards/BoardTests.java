package tests.boards;

import apis.BoardApi;
import apis.TrelloApiServer;
import io.restassured.response.Response;
import models.board.Board;
import models.board.DeleteBoardResponse;
import models.board.GetBoardsResponse;
import org.testng.annotations.Test;
import testdata.TestData_Board;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BoardTests {

    @Test
    public void testAuthentication() {
        Response response = TrelloApiServer.checkUserAuthentication();
        assertThat(response.statusCode(), equalTo(200));

    }

    @Test
    public void testCreateBoard() {

        String boardName = TestData_Board.getRandomBoardName();
        Response response = BoardApi.createBoard(boardName);
        try {
            response.prettyPrint();
            Board createBoardResponseBody = response.body().as(Board.class);

            assertThat(response.statusCode(), equalTo(200));
            assertThat(createBoardResponseBody.getName(), equalTo(boardName));
            assertThat(createBoardResponseBody.getClosed(), equalTo(false));
            assertThat(createBoardResponseBody.getPrefs().getPermissionLevel(), equalTo("private"));
            assertThat(createBoardResponseBody.getPrefs().getCanBePublic(), equalTo(true));
            assertThat(createBoardResponseBody.getPrefs().getCanInvite(), equalTo(true));
            assertThat(createBoardResponseBody.getLimits().toString(), equalTo("{}"));
        } finally {
            BoardApi.deleteBoard(response.path("id"));
        }

    }

    @Test
    public void testGetBoardsBelongsToMembermThenPrintFirstBoardIdAndLastBoardId() {
        String boardIdToBeGetted = TestData_Board.getCreatedBoardID();
        Response response = BoardApi.getBoardsBelongsToMember();
        response.prettyPrint();
        // Deserialization
        GetBoardsResponse getBoardsResponse = response.body().as(GetBoardsResponse.class);

        // Prints
        System.out.println("First Board ID: " + getBoardsResponse.getBoards().get(0).getId());
        System.out.println("Last Board ID: " + getBoardsResponse.getBoards().get(getBoardsResponse.getBoards().size() - 1).getId());
        //Assertions
        assertThat(response.statusCode(), equalTo(200));

        BoardApi.deleteBoard(boardIdToBeGetted);


    }

    @Test
    public void testDeleteBoard() {

        String boardIdToBeDeleted = TestData_Board.getCreatedBoardID();
        Response response = BoardApi.deleteBoard(boardIdToBeDeleted);
        response.prettyPrint();

        assertThat(response.statusCode(), equalTo(200));

        // [Q]Do i need to do deserilization here ? Cannot parse object because no supported Content-Type was specified in response.
        // Content-Type was 'text/plain'
        //
        DeleteBoardResponse deleteBoardResponse = response.body().as(DeleteBoardResponse.class);

        //Response Body should contain a meaningful message like "board is removed
        // successfully"."_value": null
        assertThat(deleteBoardResponse.get_value(), not("board is removed successfully"));

    }


}
