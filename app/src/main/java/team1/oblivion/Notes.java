package team1.oblivion;

public class Notes {

    String notes;

    String wardBusiness;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWardBusiness() {
        return wardBusiness;
    }

    public void setWardBusiness(String wardBusiness) {
        this.wardBusiness = wardBusiness;
    }

    public Notes(String notes, String wardBusiness) {
        this.notes = notes;
        this.wardBusiness = wardBusiness;
    }
}
