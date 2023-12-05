import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeRelated {
    String taskTime;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd-MM");
    public String startTime() {
        System.out.println("time is being taken");
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.format(formatter);
    }

    public String timeTaken(String started) {
        System.out.println("Started arg: ");
        System.out.println(started);

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("end time: " + endTime.format(formatter));

        LocalDateTime startDateTime = LocalDateTime.parse(started, formatter);
        Duration timeElapsed = Duration.between(startDateTime, endTime);

        double hours = timeElapsed.toHours();
        double minutes = timeElapsed.toMinutes()%60;

        return String.format("%.0f:%.0f", hours, minutes);
    }

    public void taskTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("When do you have to do this task");
        System.out.println("Please give the time in 'hr:min' (24hr) format: ");
        taskTime = scanner.nextLine();
    }
}