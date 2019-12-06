package team1.oblivion;

public class Meeting {

    DateTimeName dateTimeName;

    Conductors conductors;

    Hymn hymn;

    Task task;

    Notes notes;

    public DateTimeName getDateTimeName() {
        return dateTimeName;
    }

    public void setDateTimeName(DateTimeName dateTimeName) {
        this.dateTimeName = dateTimeName;
    }

    public Conductors getConductors() {
        return conductors;
    }

    public void setConductors(Conductors conductors) {
        this.conductors = conductors;
    }

    public Hymn getHymn() {
        return hymn;
    }

    public void setHymn(Hymn hymn) {
        this.hymn = hymn;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Meeting(DateTimeName dateTimeName, Conductors conductors, Hymn hymn, Task task, Notes notes) {
        this.dateTimeName = dateTimeName;
        this.conductors   = conductors;
        this.hymn         = hymn;
        this.task         = task;
        this.notes        = notes;

    }

    public void MeetingData(DateTimeName dateTimeName, Conductors conductors, Hymn hymn, Task task, Notes notes){

    }
}
