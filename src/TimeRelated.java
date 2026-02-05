import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TimeRelated {
    private static LocalDateTime taskTime;
    private LocalDateTime taskStartTime;

    public void startTime() {
        System.out.print("Type 'starting' when you will start the task: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next().toLowerCase();
        if (Pattern.matches("(?i)starting", userInput)) {
            System.out.println("Start time is taken");
            taskStartTime = LocalDateTime.now();
        }
        // scanner.close();
    }

    public void timeTaken() {
        LocalDateTime endTime = LocalDateTime.now();

        Duration timeElapsed = Duration.between(taskStartTime, endTime);

        int hours = (int) timeElapsed.toHours();
        int minutes = (int) timeElapsed.toMinutes() % 60;

        DateTimeFormatter timeTakenFormatForUser = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("You started at " + taskStartTime.format(timeTakenFormatForUser));
        System.out.println("You finished the task '" + Questions.getTask() + "' at: " + endTime.format(timeTakenFormatForUser));
        System.out.println("Total time taken for completing this task: " + hours + ":" + minutes);
    }

    public void taskTime() {
        System.out.println("\nWhen do you have to do this task\n");
        
        taskTime = getTimeInFormat();

        System.out.println("Task scheduled for: " + taskTime);
    }

    public static LocalDateTime getUserTaskStartTime() { return taskTime; }

    public static LocalDateTime getTimeInFormat(){
        Scanner scanner = new Scanner(System.in);
        // 1. Mandatory Fields
        System.out.print("Enter Hour (0-23): ");
        int hour = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter Minute (0-59): ");
        int min = Integer.parseInt(scanner.nextLine());

        // 2. Optional Fields (Defaults to today/current month)
        LocalDate today = LocalDate.now();

        System.out.print("(Optional) Enter Day (Press Enter for " + today.getDayOfMonth() + "): ");
        String dayInput = scanner.nextLine();
        int day = dayInput.isEmpty() ? today.getDayOfMonth() : Integer.parseInt(dayInput);

        System.out.print("(Optional) Enter Month (Press Enter for " + today.getMonthValue() + "): ");
        String monthInput = scanner.nextLine();
        int month = monthInput.isEmpty() ? today.getMonthValue() : Integer.parseInt(monthInput);

        // scanner.close();
        // 3. Assemble the LocalDateTime
        return LocalDateTime.of(today.getYear(), month, day, hour, min);
    }
}