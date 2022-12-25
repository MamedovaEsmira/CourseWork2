import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(title, description, isWork, dateTime);
    }
    @Override
    protected String getType() {
        return "Однократная";
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return true;
    }
}
