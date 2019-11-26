package team1.oblivion;

public class DateTimeName {
    String title;

    String time;

    String date;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public DateTimeName(String title, String time, String date) {
        this.title = title;
        this.time = time;
        this.date = date;
    }
}
