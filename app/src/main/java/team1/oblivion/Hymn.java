package team1.oblivion;

public class Hymn {

    String firstHymn;
    String secondHymn;
    String specialHymn;

    public String getFirstHymn() {
        return firstHymn;
    }

    public void setFirstHymn(String firstHymn) {
        this.firstHymn = firstHymn;
    }

    public String getSecondHymn() {
        return secondHymn;
    }

    public void setSecondHymn(String secondHymn) {
        this.secondHymn = secondHymn;
    }

    public String getSpecialHymn() {
        return specialHymn;
    }

    public void setSpecialHymn(String specialHymn) {
        this.specialHymn = specialHymn;
    }

    public Hymn(String firstHymn, String secondHymn, String specialHymn) {
        this.firstHymn = firstHymn;
        this.secondHymn = secondHymn;
        this.specialHymn = specialHymn;
    }
}
