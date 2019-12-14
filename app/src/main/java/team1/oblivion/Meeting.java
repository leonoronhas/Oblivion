package team1.oblivion;

public class Meeting {

    private DateTimeName dateTimeNames;
    private Conductors conductors;
    private Hymn hymns;
    private Task tasks;
    private Notes notes;
    private Prayer prayers;
    private Speakers speakers;

    //getters
    public Speakers getSpeakers() {
        return speakers;
    }
    public DateTimeName getDateTimeNames() {
        return dateTimeNames;
    }
    public Conductors getConductors() {
        return conductors;
    }
    public Hymn getHymns() {
        return hymns;
    }
    public Notes getNotes() {
        return notes;
    }
    public Prayer getPrayers() {
        return prayers;
    }

    //setters
    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }
    public void setDateTimeNames(DateTimeName dateTimeNames) {
        this.dateTimeNames = dateTimeNames;
    }
    public void setConductors(Conductors conductors) {
        this.conductors = conductors;
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
    public void setNotes(Notes notes) {
        this.notes = notes;
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
