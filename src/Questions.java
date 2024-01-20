import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Questions {
    static String task;
    String details;
    private String deadline;
    static long interval;
    static int  numberOfTimes;
    public void about() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me about the task: ");
        task = scanner.nextLine();
        System.out.print("Do you want to give a description for the task?\n\tType 'Yes' if you want to: ");
        if(Objects.equals(scanner.nextLine(), "Yes"))   this.details = scanner.nextLine();
    }

    public void askDeadline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to keep a deadline or time limit for the task?\n\tType 'Yes' if you want to: ");
        if (Objects.equals(scanner.next(), "Yes")) {
            System.out.println("Please state the time limit in YYYY-MM-DD HH:mm format: ");
            scanner.nextLine();
            deadline = scanner.nextLine();
        }
    }

    public boolean repeat(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want the task to repeat?\n\tType 'Yes' if you want to: ");
        if (Objects.equals(scanner.next(), "Yes")) {
            System.out.println("Enter the number of times to repeat the reminder:");
            numberOfTimes = scanner.nextInt();
            System.out.println("Enter the interval between reminders in minutes:");
            interval = scanner.nextLong();
            return true;
        }
        else    return false;
    }

    public static long getInterval(){return interval;}

    public static int getNumberOfTimes(){return numberOfTimes;}

    public static String getTask(){return task;}

    public boolean finish(){
        System.out.println("When finished type 'done'");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The deadline for this task is: " + deadline);

        if(deadline!=null){
            LocalDateTime deadlineInFormat = TimeRelated.getTimeInFormat(deadline);
            Thread deadlineThread = getThread(deadlineInFormat);

            String confirmation = "";
            while (!confirmation.equals("done"))    confirmation = scanner.nextLine();
            deadlineThread.interrupt();
        } else {
            String confirmation = "";
            while (!confirmation.equals("done"))    confirmation = scanner.nextLine();
        }
        return true;
    }

    private static Thread getThread(LocalDateTime deadlineInFormat) {
        Thread deadlineThread = new Thread(() -> {
            while (LocalDateTime.now().isBefore(deadlineInFormat)) {
                try {
                    Thread.sleep(1000);
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