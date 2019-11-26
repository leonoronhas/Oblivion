package team1.oblivion;

public class Prayer {

    String invocation;

    String benediction;

    String specialPrayer;

    public String getInvocation() {
        return invocation;
    }

    public void setInvocation(String invocation) {
        this.invocation = invocation;
    }

    public String getBenediction() {
        return benediction;
    }

    public void setBenediction(String benediction) {
        this.benediction = benediction;
    }

    public String getSpecialPrayer() {
        return specialPrayer;
    }

    public void setSpecialPrayer(String specialPrayer) {
        this.specialPrayer = specialPrayer;
    }

    public Prayer(String invocation, String benediction, String specialPrayer) {
        this.invocation = invocation;
        this.benediction = benediction;
        this.specialPrayer = specialPrayer;
    }
}
