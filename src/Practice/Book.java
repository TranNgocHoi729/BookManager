package Practice;

public class Book {
    private String titleID ,title, pubID , note , userName;

    public String getTitleID() {
        return titleID;
    }

    public String getTitle() {
        return title;
    }

    public String getPubID() {
        return pubID;
    }

    public String getNote() {
        return note;
    }

    public String getUserName() {
        return userName;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubID(String pubID) {
        this.pubID = pubID;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Book(String titleID, String title, String pubID, String note, String userName) {
        this.titleID = titleID;
        this.title = title;
        this.pubID = pubID;
        this.note = note;
        this.userName = userName;
    }
    
    
}
