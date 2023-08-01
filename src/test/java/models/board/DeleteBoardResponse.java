package models.board;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBoardResponse {

    @JsonProperty("_value")
    private String _value;
    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }


}
