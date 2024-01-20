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
        int minutes = (int) timeElapsed.toMinutes() % 60;

        DateTimeFormatter timeTakenFormatForUser = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("You started at " + taskStartTime.format(timeTakenFormatForUser));
        System.out.println("You finished the task " + Questions.task + " at: " + endTime.format(timeTakenFormatForUser));
        System.out.println("Total time taken for completing this task: " + hours + ":" + minutes);
    }

    public void taskTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhen do you have to do this task");
        System.out.println("Please give the time in 'YYYY-MM-DD HH:mm' (24hr) format: ");
        String userTaskTime = scanner.nextLine();
        taskTime = getTimeInFormat(userTaskTime);
    }

    public static LocalDateTime getUserTaskStartTime() {
        return taskTime;
    }

    public static LocalDateTime getTimeInFormat(String time){
        DateTimeFormatter formatUserTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(time, formatUserTime);
    }
}