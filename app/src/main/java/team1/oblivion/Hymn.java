package team1.oblivion;

public class Hymn {

    String openingHymn;
    String sacramentHymn;
    String specialHymn;
    String closingHymn;

    public String getOpeningHymn() {
        return openingHymn;
    }

    public void setOpeningHymn(String openingHymn) {
        this.openingHymn = openingHymn;
    }

    public String getSacramentHymn() {
        return sacramentHymn;
    }

    public void setSacramentHymn(String sacramentHymn) {
        this.sacramentHymn = sacramentHymn;
    }

    public String getSpecialHymn() {
        return specialHymn;
    }

    public void setSpecialHymn(String specialHymn) {
        this.specialHymn = specialHymn;
    }

    public String getClosingHymn() {
        return closingHymn;
    }

    public void setClosingHymn(String closingHymn) {
        this.closingHymn = closingHymn;
    }

    public Hymn(String openingHymn, String sacramentHymn, String specialHymn, String closingHymn) {
        this.openingHymn = openingHymn;
        this.sacramentHymn = sacramentHymn;
        this.specialHymn = specialHymn;
        this.closingHymn = closingHymn;
    }
}