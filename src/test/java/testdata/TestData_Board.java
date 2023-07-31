package testdata;

import apis.BoardApi;
import io.restassured.response.Response;

import java.util.Random;

public class TestData_Board {


    public static String getCreatedBoardID(){

        String boardName =getRandomBoardName();
        Response response = BoardApi.createBoard(boardName);
        return response.path("id");

    }

    public static String getRandomBoardName() {
        final String[] BOARD_NAMES = {
                "Chess Board", "Scrabble Board", "Monopoly Board", "Catan Board", "Ouija Board",
                "Checkers Board", "Sudoku Board", "Parcheesi Board", "Battleship Board", "Risk Board"
        };
        final Random random = new Random();

        int randomIndex = random.nextInt(BOARD_NAMES.length);

        return BOARD_NAMES[randomIndex];
    }


}
