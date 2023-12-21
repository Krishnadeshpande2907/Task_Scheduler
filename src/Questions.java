import java.util.Objects;
import java.util.Scanner;

public class Questions {
    static String task;
    String details;
    String deadline;
    static long interval;
    static int  numberOfTimes;
    public void about() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me about the task: ");
        task = scanner.nextLine();
        System.out.print("Do you want to give a description for the task?\n\tType 'Yes' if you want to: ");
        if(Objects.equals(scanner.nextLine(), "Yes"))   details = scanner.nextLine();
    }

    public void askDeadline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to keep a deadline or time limit for the task?\n\tType 'Yes' if you want to: ");
        if (Objects.equals(scanner.next(), "Yes")) {
            System.out.println("Please state the time limit in YYYY-MM-DD HH:mm format: ");
            deadline = scanner.next();
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

    public boolean finish() {
        Scanner scanner = new Scanner(System.in);
        String confirmation = "";
        System.out.print("When finished type 'done' ahead: ");
        while (!confirmation.equals("done"))    confirmation = scanner.nextLine();
        return true;
    }

    public void info(){
        System.out.println("Task: " + task);
        if(details!=null)   System.out.println("Details of the task: " + details);
        if(deadline!=null)  System.out.println("Deadline of the Task " + deadline);
    }
}