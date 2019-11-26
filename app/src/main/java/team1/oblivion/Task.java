package team1.oblivion;

public class Task {

    Speakers speakers;

    Notes notes;

    Prayer prayer;

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Prayer getPrayer() {
        return prayer;
    }

    public void setPrayer(Prayer prayer) {
        this.prayer = prayer;
    }

    public Task(Speakers speakers, Notes notes, Prayer prayer) {
        this.speakers = speakers;
        this.notes = notes;
        this.prayer = prayer;
    }
}
