import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task{


    public AnnualTask(String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(title, description, isWork, dateTime);
    }

    public boolean checkIfSuitable(LocalDate date) {
        boolean b = date.isAfter(dateTime.toLocalDate())
        && date.getDayOfYear() == dateTime.getDayOfYear()
                || dateTime.isEqual(dateTime.toLocalDate().atStartOfDay());
        return b;
    }
    @Override
    protected String getType() {
        return "Ежегодная";
    }
}
