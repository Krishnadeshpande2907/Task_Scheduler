import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeRelated {
    LocalDateTime taskTime;
    LocalDateTime taskStartTime;
    public void startTime() {
        System.out.println("Start time is taken");
        taskStartTime = LocalDateTime.now();
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
}