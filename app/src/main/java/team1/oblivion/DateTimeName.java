package team1.oblivion;

public class DateTimeName {

    private String title;
    private String time;
    private String date;
    private String fbKey;

    //getters
    public String getTitle() {
        return title;
    }
    public String getTime() {
        return time;
    }
    public String getDate() {
        return date;
    }
    public String getFbKey() {
        return fbKey;
    }

    //setters
    public void setFbKey(String fbKey) {
        this.fbKey = fbKey;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setDate(String date) {
        this.date = date;
    }


    DateTimeName(String title, String time, String date, String fbKey) {
        this.title = title;
        this.time = time;
        this.date = date;
        this.fbKey = fbKey;
    }

    public DateTimeName() {
    }

    @Override
    public String toString() {
        return title + " " + date + " | " + time ;
    }
}
