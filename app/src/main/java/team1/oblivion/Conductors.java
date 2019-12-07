package team1.oblivion;

public class Conductors {

    private String presiding;

    private String conducting;

    public Conductors() {
    }

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

    Conductors(String presiding, String conducting) {
        this.presiding = presiding;
        this.conducting = conducting;
    }
}
