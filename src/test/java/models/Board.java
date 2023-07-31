package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {


    private String id;
    private String name;
    private String desc;
    private Boolean closed;
    private Prefs prefs;
    private ArrayList<Boards> boards;


    public Board(){

    }
    public Board(String boardName){
        this.name = boardName;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }
    public ArrayList<Boards> getBoards() {
        return boards;
    }

    public void setBoards(ArrayList<Boards> boards) {
        this.boards = boards;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Prefs{
        private String permissionLevel;
        private Boolean canBePublic;
        private Boolean canInvite;

        public String getPermissionLevel() {
            return permissionLevel;
        }

        public void setPermissionLevel(String permissionLevel) {
            this.permissionLevel = permissionLevel;
        }

        public Boolean getCanBePublic() {
            return canBePublic;
        }

        public void setCanBePublic(Boolean canBePublic) {
            this.canBePublic = canBePublic;
        }

        public Boolean getCanInvite() {
            return canInvite;
        }

        public void setCanInvite(Boolean canInvite) {
            this.canInvite = canInvite;
        }

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Boards{
        private String id;
        private String name;
        private Boolean closed;
        private String idOrganization;
        private Boolean pinned;

        public Boards(){}


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getClosed() {
            return closed;
        }

        public void setClosed(Boolean closed) {
            this.closed = closed;
        }

        public String getIdOrganization() {
            return idOrganization;
        }

        public void setIdOrganization(String idOrganization) {
            this.idOrganization = idOrganization;
        }

        public Boolean getPinned() {
            return pinned;
        }

        public void setPinned(Boolean pinned) {
            this.pinned = pinned;
        }

    }

}
