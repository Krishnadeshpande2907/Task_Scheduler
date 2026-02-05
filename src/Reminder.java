import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Reminder {

    public void remind(){
        while (LocalDateTime.now().isBefore(TimeRelated.getUserTaskStartTime())){}
        System.out.println("It is time to do your task");
    }

    public void repeatingReminders(){
        Questions question = new Questions();
        int numberOfTimes = question.getNumberOfTimes();
        int interval = question.getInterval();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable reminderTask = () -> {
            for (int i = 0; i < numberOfTimes; i++) {
                System.out.println("Reminder to do your task: \n");
                question.info();
                try {
                    Thread.sleep(interval * 60 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
        };

        long delay = Duration.between(LocalTime.now(), TimeRelated.getUserTaskStartTime()).toMillis();
        executorService.scheduleAtFixedRate(reminderTask, delay, interval * 60, TimeUnit.SECONDS);
    }
}
