import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeRelated {
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
}