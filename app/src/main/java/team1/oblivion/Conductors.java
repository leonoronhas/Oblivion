package team1.oblivion;

public class Conductors {

    String presiding;

    String conducting;

//    String pianist;
//
//    String musicConductor;

    public String getPresiding() {
        return presiding;
    }

    public void setPresiding(String presiding) {
        this.presiding = presiding;
    }

    public String getConducting() {
        return conducting;
    }

    public void setConducting(String conducting) {
        this.conducting = conducting;
    }

    public Conductors(String presiding, String conducting) {
        this.presiding = presiding;
        this.conducting = conducting;
    }
}
