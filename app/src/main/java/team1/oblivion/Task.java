package team1.oblivion;

public class Task {

    private Speakers speakers;

    private Prayer prayer;

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Prayer getPrayer() {
        return prayer;
    }

    public void setPrayer(Prayer prayer) {
        this.prayer = prayer;
    }

    public Task(Speakers speakers, Prayer prayer) {
        this.speakers = speakers;
        this.prayer = prayer;
    }

    public Task() {
    }
}
