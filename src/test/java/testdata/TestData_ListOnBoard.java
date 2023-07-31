package testdata;

import apis.ListApi;
import io.restassured.response.Response;

import java.util.Random;

public class TestData_ListOnBoard {

    public static String getRandomListName() {
        final String[] List_NAMES = {
                "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot",
                "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima",
                "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo",
                "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray",
                "Yankee", "Zulu", "Apple", "Banana", "Cherry", "Grape",
                "Kiwi", "Lemon", "Mango", "Orange", "Peach", "Pear",
                "Pineapple", "Strawberry", "Watermelon"
        };
        final Random random = new Random();

        int randomIndex = random.nextInt(List_NAMES.length);

        return List_NAMES[randomIndex];
    }

    public static String getCreatedListID(String boardId){
        //String boardId = TestData_Board.getCreatedBoardID();
        String listName =getRandomListName();
        Response response = ListApi.createListOnBoard(boardId,listName);
        return response.path("id");

    }
}
