package team1.oblivion;

public class Speakers {

    String firstSpeaker;

    String secondSpeaker;

    String thirdSpeaker;

    public String getFirstSpeaker() {
        return firstSpeaker;
    }

    public void setFirstSpeaker(String firstSpeaker) {
        this.firstSpeaker = firstSpeaker;
    }

    public String getSecondSpeaker() {
        return secondSpeaker;
    }

    public void setSecondSpeaker(String secondSpeaker) {
        this.secondSpeaker = secondSpeaker;
    }

    public String getThirdSpeaker() {
        return thirdSpeaker;
    }

    public void setThirdSpeaker(String thirdSpeaker) {
        this.thirdSpeaker = thirdSpeaker;
    }

    public Speakers(String firstSpeaker, String secondSpeaker, String thirdSpeaker) {
        this.firstSpeaker = firstSpeaker;
        this.secondSpeaker = secondSpeaker;
        this.thirdSpeaker = thirdSpeaker;
    }
}
