import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Service calendar;
    public static void main(String[] args) {
        calendar=new Service();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            removeTask (scanner);
                            break;
                        case 3:
                           getTaskForDay(scanner);
                           break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        // title input
        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine();
        // description input
        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();
        // isWork input
        boolean isWork;
        System.out.println("Эта задача рабочая?");
        switch (scanner.nextLine()) {
            case "1":
            case "да":
            case "д":
            case "y":
            case "yes":
            case "Y":
            case "YES":
                isWork = true;
                break;
            default:
                isWork = false;
        }
        // date input
        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи (01.01.2020 00:00:00):");
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("WRONG FORMAT, ENTER AGAIN");
            }
        }
        // creation of Task
        Task task;
        System.out.println("========================================");
        System.out.println("Повторяемость задания:");
        System.out.println("\t • 0 – не повторяется (default)");
        System.out.println("\t • 1 – ежедневно");
        System.out.println("\t • 2 – еженедельно");
        System.out.println("\t • 3 – ежемесячно");
        System.out.println("\t • 4 – ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, description, isWork, date);
                break;
            case "2":
                task = new WeeklyTask(title, description, isWork, date);
                break;
            case "3":
                task = new MonthlyTask(title, description, isWork, date);
                break;
            case "4":
                task = new AnnualTask(title, description, isWork, date);
                break;
            default:
                task = new OneTimeTask(title, description, isWork, date);
        }
        calendar.addTask(task);
    }
    private static void removeTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Введите ID удаляемой задачи:");
        boolean shouldEnterAgain = true;
        int id = 0;
        while (shouldEnterAgain) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                shouldEnterAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("WRONG_FORMAT");
            }
        }
        if (calendar.removeTask(id)) {
            System.out.println("Задача была успешно удалена!");
        } else {
            System.out.println("Задача с таким ID отсутствует в календаре.");
        }
        System.out.println("========================================");
        System.out.println();
    }
public static void getTaskForDay(Scanner scanner) {
    scanner.nextLine();
    System.out.println("Введите дату (01.01.2000):");
    LocalDate date = null;
    boolean shouldEnterAgain = true;
    while (shouldEnterAgain) {
        try {
            date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
            shouldEnterAgain = false;
        } catch (DateTimeParseException e) {
            System.out.println("WRONG FORMAT, ENTER AGAIN");
        }
    }
    System.out.println(calendar.getTasksForOneDay(date));
}
    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "0. Выход");
    }
}