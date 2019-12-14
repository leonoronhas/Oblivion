package team1.oblivion;

public class Prayer {

    private String firstPrayer;
    private String secondPrayer;

    // Getters and Setters
    public String getfirstPrayer() {
        return firstPrayer;
    }
    public String getsecondPrayer() {
        return secondPrayer;
    }
    public void setfirstPrayer(String firstPrayer) {
        this.firstPrayer = firstPrayer;
    }
    public void setsecondPrayer(String secondPrayer) {
        this.secondPrayer = secondPrayer;
    }

    Prayer(String firstPrayer, String secondPrayer) {
        this.firstPrayer = firstPrayer;
        this.secondPrayer = secondPrayer;
    }

    public Prayer() {
    }
}
