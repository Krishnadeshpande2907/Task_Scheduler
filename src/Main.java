public class Main {
    public static void main(String[] args) {
        // objects
        TimeRelated timeQuestions = new TimeRelated();
        Questions question = new Questions();

        // Actual Code below:
        // askingUser about the project
        question.about();

        // Asking the time to do that task
        timeQuestions.taskTime();

        // Amount of time estimated to do that task
        question.askDeadline();

        Reminder reminder = new Reminder();

//        Asking if the task should repeat
        if(question.repeat()){
            reminder.repeatingReminders();
        }else{
            reminder.remind();
        }

//        Creating while loop till the task is executed
        boolean taskDone = false;
        while (!taskDone){
            // Getting the time at which I start the task
            timeQuestions.startTime();
            taskDone = question.finish();
        }

//        Info regarding the task
        question.info();

        // Time taken to complete the task
        timeQuestions.timeTaken();
    }
}