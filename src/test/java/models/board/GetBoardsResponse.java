package models.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Model class represent response of Get "Boards" API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBoardsResponse {

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    private List<Board> boards;



}
