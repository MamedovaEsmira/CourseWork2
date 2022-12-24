import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repeatable {


    public AnnualTask(String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(title, description, isWork, dateTime);
    }

    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfMonth() == dateTime.getDayOfMonth()
                && date.getMonth()==dateTime.getMonth();
    }
    @Override
    protected String getType() {
        return "Ежегодная";
    }
}
