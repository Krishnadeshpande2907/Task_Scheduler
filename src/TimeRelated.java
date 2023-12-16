import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class TimeRelated {
    public static LocalDateTime taskTime;
    private LocalDateTime taskStartTime;
    public void startTime() {
        System.out.print("Type 'starting' when you will start the task: ");
        Scanner scanner = new Scanner(System.in);
        if (Objects.equals(scanner.next(), "starting")) {
            System.out.println("Start time is taken");
            taskStartTime = LocalDateTime.now();
        }
    }

    public void timeTaken() {
        LocalDateTime endTime = LocalDateTime.now();

        Duration timeElapsed = Duration.between(taskStartTime, endTime);

        int hours = (int) timeElapsed.toHours();
        int minutes = (int) timeElapsed.toMinutes()%60;

        DateTimeFormatter endTimeTakenFormat = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("end time: " + endTime.format(endTimeTakenFormat));
        System.out.println("Total time taken for completing this task: " + hours + ":" + minutes);
    }

    public void taskTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhen do you have to do this task");
        System.out.println("Please give the time in 'YYYY-MM-DD HH:mm' (24hr) format: ");
        String userTaskTime = scanner.nextLine();
        DateTimeFormatter formatUserTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        taskTime = LocalDateTime.parse(userTaskTime, formatUserTime);
    }

    public static LocalDateTime getUserTaskStartTime() {
        return taskTime;
    }
}