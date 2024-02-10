import java.util.*;
import out.*;



public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Welcome to Ziz Password Services :)\n");
        boolean exit = false;

        while(exit == false) {

            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter 1 - Password Generator");
                System.out.println("Enter 2 - Password Strength Check");
                System.out.println("Enter 3 - Useful Information");
                System.out.println("Enter 4 - Quit");
                System.out.print("Choice:");
                int choice = sc.nextInt();
                switch(choice) {
                    case(1) -> {
                        Generate g = new Generate(sc, random);
                        g.user_questions();
                        break;
                    }
                    case(2) -> {
                        Strength c = new Strength(sc);
                        c.check_password_strength();
                        break;
                    }
                    case(3) -> {
                        Info u = new Info();
                        u.getInfo();
                        break;
                    }
                    case(4)-> {
                        exit = true;
                        System.out.println("Closing the program bye bye!");
                        break;
                    }
                }
            } catch(Exception e) {
                System.out.println("\nKindly select one of the available commands\n");
            }
            
        }
        
    }
}



