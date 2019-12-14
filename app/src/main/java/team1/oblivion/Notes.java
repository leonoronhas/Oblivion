package team1.oblivion;

public class Notes {

    private String notes;
    private String wardBusiness;
    private String attendance;

    // Getters
    public String getAttendance() {
        return attendance;
    }
    public String getNotes() {
        return notes;
    }
    public String getWardBusiness() {
        return wardBusiness;
    }
    // Setters
    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setWardBusiness(String wardBusiness) {
        this.wardBusiness = wardBusiness;
    }

    //constructor
    Notes(String notes, String wardBusiness, String attendance) {
        this.notes = notes;
        this.attendance = attendance;
        this.wardBusiness = wardBusiness;
    }

    public Notes() {
    }
}
