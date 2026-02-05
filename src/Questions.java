import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Questions {
    private static String task;
    private static String details;
    private static LocalDateTime deadline;
    private static int interval;
    private static int  numberOfTimes;
    
    public void about() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me about the task: ");
        task = scanner.nextLine();
        System.out.print("Do you want to give a description for the task?\n\tType 'yes' if you want to: ");
        String userInput = scanner.nextLine().toLowerCase();
        if (Pattern.matches("(?i)yes", userInput)){
            System.out.println("Provide the details:");
            details = scanner.nextLine();
        }
        // scanner.close();
    }

    public void askDeadline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to keep a deadline or time limit for the task?\n\tType 'yes' if you want to: ");
        String userInput = scanner.next().toLowerCase();
        if (Pattern.matches("(?i)yes", userInput))  deadline = TimeRelated.getTimeInFormat();
        // scanner.close();
    }

    public boolean repeat(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want the task to repeat?\n\tType 'yes' if you want to: ");
        String userInput = scanner.nextLine().toLowerCase();
        if (Pattern.matches("(?i)yes", userInput)) {
            System.out.println("Enter the number of times to repeat the reminder:");
            numberOfTimes = scanner.nextInt();
            System.out.println("Enter the interval between reminders in minutes:");
            interval = scanner.nextInt();
            // scanner.close();
            return true;
        }
        else{
            // scanner.close();
            return false;
        }
    }

    public int getInterval(){ return interval; }

    public int getNumberOfTimes(){ return numberOfTimes; }

    public static String getTask(){ return task; }

    public boolean finish(){
        System.out.println("When finished type 'done'");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The deadline for this task is: " + deadline);

        if(deadline!=null){
            Thread deadlineThread = getThread(deadline);

            String confirmation = "";
            while (!confirmation.equals("done")) {
                confirmation = scanner.nextLine().toLowerCase();
                if (Pattern.matches("(?i)done", confirmation))  continue;
            }
            deadlineThread.interrupt();
        } else {
            String confirmation = "";
            while (!confirmation.equals("done")) {
                confirmation = scanner.nextLine().toLowerCase();
                if (Pattern.matches("(?i)done", confirmation))  continue;
            }
        }
        return true;
    }

    private Thread getThread(LocalDateTime deadline) {
        Thread deadlineThread = new Thread(() -> {
            while (LocalDateTime.now().isBefore(deadline)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Deadline has been passed!!!");
        });
        deadlineThread.start();
        return deadlineThread;
    }

    public void info(){
        System.out.println("Task: " + task);
        if(details!=null)   System.out.println("Details of the task: " + details);
        if(deadline!=null)  System.out.println("Deadline of the Task was: " + deadline);
    }
}