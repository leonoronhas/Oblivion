package team1.oblivion;

public class Prayer {

    String firstPrayer;

    String secondPrayer;

    String specialPrayer;

    public String getfirstPrayer() {
        return firstPrayer;
    }

    public void setfirstPrayer(String firstPrayer) {
        this.firstPrayer = firstPrayer;
    }

    public String getsecondPrayer() {
        return secondPrayer;
    }

    public void setsecondPrayer(String secondPrayer) {
        this.secondPrayer = secondPrayer;
    }

    public String getSpecialPrayer() {
        return specialPrayer;
    }

    public void setSpecialPrayer(String specialPrayer) {
        this.specialPrayer = specialPrayer;
    }

    public Prayer(String firstPrayer, String secondPrayer, String specialPrayer) {
        this.firstPrayer = firstPrayer;
        this.secondPrayer = secondPrayer;
        this.specialPrayer = specialPrayer;
    }
}
