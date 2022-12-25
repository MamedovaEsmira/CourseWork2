import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(title, description, isWork, dateTime);
    }
    public boolean checkIfSuitable(LocalDate date) {
        return (date.isAfter(dateTime.toLocalDate()))
               && date.getDayOfMonth()==dateTime.getDayOfMonth()
                ||date.isEqual(dateTime.toLocalDate());
    }
    @Override
    protected String getType() {
        return "Ежемесячная";
    }
}
