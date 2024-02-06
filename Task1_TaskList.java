import java.util.*;

public class NewTask {

    public static void ListTask(ArrayList<String> li) {
        if (li.isEmpty()) System.out.println("No tasks to show");
        else {
            for (int i=0; i<li.size(); i++) {
                System.out.println((i+1) + ". " + li.get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> li = new ArrayList<>();
        int option;

        while (true) {        
            System.out.println("Task List Application");
            System.out.print("1. Add Task \n2. Remove Task \n3. List Task \n4. Quit\nSelect an option: ");
            option = sc.nextInt();
            while ( option > 4 || option < 0) {
                System.out.print("Invalid Option\nSelect an option: ");
                option = sc.nextInt();
            }
            sc.nextLine();

            if (option == 1) {
                System.out.print("Enter task name: ");
                String taskName = sc.next();
                li.add(taskName);
                System.out.println("Task added.");
            }

            else if(option == 2) {
                ListTask(li);
                System.out.print("Enter task number to remove: ");
                int taskNumber = sc.nextInt();
                while (taskNumber > li.size() || taskNumber <= 0) {
                    System.out.print("Enter the correct task number to remove: ");
                    taskNumber = sc.nextInt();
                }
                li.remove(taskNumber-1);
                System.out.println("Task removed.");
            }

            else if(option == 3) ListTask(li);

            else break;

        }
        sc.close();
        
    }
}