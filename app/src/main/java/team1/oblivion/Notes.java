package team1.oblivion;

public class Notes {

    String notes;

    String wardBusiness;

    String attendance;

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

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



    //constructor
    public Notes(String notes, String wardBusiness, String attendance) {
        this.notes = notes;
        this.attendance = attendance;
        this.wardBusiness = wardBusiness;
    }

    public Notes() {
    }
}
