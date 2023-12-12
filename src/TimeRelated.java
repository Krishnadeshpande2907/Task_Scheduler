import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeRelated {
    LocalDateTime taskTime;
    LocalDateTime taskStartTime;
    public void startTime() {
        System.out.println("Start time is being taken");
        taskStartTime = LocalDateTime.now();
    }

    public void timeTaken() {
        LocalTime endTime = LocalTime.now();
        DateTimeFormatter timeTakenFormat = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("end time: " + endTime.format(timeTakenFormat));

        Duration timeElapsed = Duration.between(taskStartTime, endTime);

        double hours = timeElapsed.toHours();
        double minutes = timeElapsed.toMinutes()%60;
        System.out.println("Total time taken for completing this task: " + hours + ":" + minutes);
    }

    public void taskTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("When do you have to do this task");
        System.out.println("Please give the time in 'YYYY-MM-DD HH:mm' (24hr) format: ");
        String userTaskTime = scanner.nextLine();
        DateTimeFormatter formatUserTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        taskTime = LocalDateTime.parse(userTaskTime, formatUserTime);
    }
}