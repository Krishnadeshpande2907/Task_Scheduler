public class Main {
    public static void main(String[] args) {
        // askingUser about the project
        Questions question = new Questions();
        question.about();

        // Asking the time to do that task
        TimeRelated timeQuestions = new TimeRelated();
        timeQuestions.taskTime();

        // Amount of time estimated to do that task
        question.askDeadline();

//        Asking if the task should repeat
        Reminder reminder = new Reminder();
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