
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public  abstract class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static int counter;

    private final int id;
    private String title;
    private String description;
    private final boolean isWork;
    protected LocalDateTime dateTime;

    public Task(String title,String description,boolean isWork,LocalDateTime dateTime) {
        this.id = ++counter;
        this.title=title;
        this.description=description;
        this.isWork=isWork;
        this.dateTime=dateTime;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean isWork() {
        return isWork;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && description.equals(task.description) && dateTime.equals(task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dateTime);
    }

    @Override
    public String toString() {
        return "Задача (ID) [" + id +
                "]: название " + title +
                ", описание " + description +
                ", дата " + dateTime +
                ", " + (isWork? "рабочая" : "личная")  + ".";
    }
    protected abstract String getType();
}
