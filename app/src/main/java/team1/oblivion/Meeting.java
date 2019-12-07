package team1.oblivion;

public class Meeting {

    DateTimeName dateTimeNames;
    Conductors conductors;
    Hymn hymns;
    Task tasks;
    Notes notes;
    Prayer prayers;
    Speakers speakers;



    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public DateTimeName getDateTimeNames() {
        return dateTimeNames;
    }

    public void setDateTimeNames(DateTimeName dateTimeNames) {
        this.dateTimeNames = dateTimeNames;
    }

    public Conductors getConductors() {
        return conductors;
    }

    public void setConductors(Conductors conductors) {
        this.conductors = conductors;
    }

    public Hymn getHymns() {
        return hymns;
    }

    public void setHymns(Hymn hymns) {
        this.hymns = hymns;
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Prayer getPrayers() {
        return prayers;
    }

    public void setPrayers(Prayer prayers) {
        this.prayers = prayers;
    }

    public Meeting() {
    }

    public Meeting(DateTimeName dateTimeNames, Conductors conductors, Hymn hymns, Task tasks, Notes notes, Prayer prayers, Speakers speakers) {
        this.dateTimeNames = dateTimeNames;
        this.conductors    = conductors;
        this.hymns         = hymns;
        this.tasks         = tasks;
        this.notes         = notes;
        this.prayers       = prayers;
        this.speakers      = speakers;

    }

    @Override
    public String toString() {
        return "" + dateTimeNames;
    }
}
