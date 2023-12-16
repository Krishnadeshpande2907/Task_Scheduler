import java.time.LocalDateTime;

public class Reminder {

    public void remind(){
//        System.out.println(taskTime);
        while (LocalDateTime.now().isBefore(TimeRelated.getUserTaskStartTime()) || LocalDateTime.now().isEqual(TimeRelated.getUserTaskStartTime())) {
            try {
                Thread.sleep(10000); // Wait for 10 seconds
            } catch (InterruptedException e) {
                System.out.println("Reminder interrupted");
            }
        }
        System.out.println("It is time to do your task");
    }
}
