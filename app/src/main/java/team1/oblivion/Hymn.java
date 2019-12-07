package team1.oblivion;

public class Hymn {

    private String openingHymn;
    private String sacramentHymn;
    private String specialHymn;
    private String closingHymn;

    Hymn(String openingHymn, String sacramentHymn, String specialHymn, String closingHymn) {
        this.openingHymn = openingHymn;
        this.sacramentHymn = sacramentHymn;
        this.specialHymn = specialHymn;
        this.closingHymn = closingHymn;
    }

    public Hymn() {
    }

    // Getters
    public String getOpeningHymn() {
        return openingHymn;
    }
    public String getSacramentHymn() {
        return sacramentHymn;
    }
    public String getSpecialHymn() {
        return specialHymn;
    }
    public String getClosingHymn() {
        return closingHymn;
    }

    // Setters
    public void setOpeningHymn(String openingHymn) {
        this.openingHymn = openingHymn;
    }
    public void setSacramentHymn(String sacramentHymn) {
        this.sacramentHymn = sacramentHymn;
    }
    public void setSpecialHymn(String specialHymn) {
        this.specialHymn = specialHymn;
    }
    public void setClosingHymn(String closingHymn) {
        this.closingHymn = closingHymn;
    }
}