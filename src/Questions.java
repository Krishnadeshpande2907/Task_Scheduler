import java.util.Objects;
import java.util.Scanner;

public class Questions {
    String task;
    String details;
    String deadline;
    public void about() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me about the task: ");
        task = scanner.nextLine();
        System.out.print("Do you want to give a description for the task?\n\tType 'Yes' if you want to.");
        if(Objects.equals(scanner.next(), "Yes")){
            details = scanner.nextLine();
        }
        scanner.close();
    }


    public void askDeadline() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to keep a deadline or time limit for the task?\n\tType 'Yes' if you want to.");
        if (Objects.equals(scanner.next(), "Yes")) {
            System.out.println("Please state the time limit in hr:min format: ");
            deadline = scanner.next();
        }
    }

    public void finish() {
        Scanner scanner = new Scanner(System.in);
        String confirmation = "";
        System.out.println("When finished type 'done' ahead: ");
        while (!confirmation.equals("done")) {
            confirmation = scanner.nextLine();
        }
    }
}