//import schedule.Schedule;
//import Time.Time;
//import questions.Questions;

public class Main {
    public static void main(String[] args) {
        // import files
        TimeRelated timeQuestions = new TimeRelated();
        Questions question = new Questions();
//        Schedule scheduleObj = new Schedule();

        // Different time intervals:
        // schedule.every(2).hours.do(job);
        // schedule.every(2).minutes.do(job);
        // schedule.every(2).day.do(job);
        // schedule.every(2).monday.do(job);
        // schedule.every(2).weeks.do(job);
        // schedule.every(2).day.at(18.30).do(job); // schedule at a time on a day
        // schedule.every(2).minute.at(:30).do(job); // schedule at every XX:30(min:sec) minute (10:50:30)(hr:min:sec)
        // schedule.every().year.on('7-29').do(job); // schedules the job on 29th of July every year
        // schedule.every().hour.until(time(2, 50, 40)).do(job); // here time: (hr, min, sec, micro...)
        // schedule.every().hour.until(timedelta(minutes=30)).do(job); // here timedelta: difference between each reminder
        // while True: // unending loop
        //     schedule.run_pending();
        //     tm.sleep(1);

        // Actual Code below:
        // Scanner scanner = new Scanner(System.in);

        // askingUser about the project -> not done yet
        question.about();

        // Asking the time to do that task
        String timeOfTask = question.taskTime();
        System.out.println(timeOfTask);

        // Amount of time estimated to do that task
        String timeLimitIfRequired = question.deadline();

        // getTime = Time
        String taskStarted = timeQuestions.startTime();
        System.out.println("time: ");
        System.out.println(taskStarted);

        String timeTaken = timeQuestions.timeTaken(taskStarted);
        System.out.println(timeTaken);
    }
}