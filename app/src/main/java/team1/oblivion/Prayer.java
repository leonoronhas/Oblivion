package team1.oblivion;

public class Prayer {

    String firstPrayer;

    String secondPrayer;


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


    public Prayer(String firstPrayer, String secondPrayer) {
        this.firstPrayer = firstPrayer;
        this.secondPrayer = secondPrayer;
    }
}
