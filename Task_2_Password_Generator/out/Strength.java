package out;
import java.util.Scanner;

public class Strength {
    Scanner scanner;
    public Strength(Scanner scanner) {
        this.scanner = scanner;
    }


    public void check_password_strength() {
        System.out.print("\nEnter your password:");
        String user_password = scanner.next();
        int uppercase = 0, lowercase = 0, numbers = 0, symbols = 0;
        for (int i = 0; i < user_password.length(); ++i){
            if (Character.isUpperCase(user_password.charAt(i))) {
                uppercase=1;
            } else if (Character.isLowerCase(user_password.charAt(i))){
                lowercase=1;
            }
            else if (Character.isDigit(user_password.charAt(i))) { 
                numbers=1;

            }
            else if(user_password.matches(".*[!@#$&^,].*")) {
                symbols=1;
            }
        }
        int check = numbers + uppercase + lowercase + symbols;
        
        int length = user_password.length();
        print(check, length);
        
    }

    public static void print(int n, int length) {
        if (n == 4) {
            if (length >= 8) 
                System.out.println("This is a good password :/ but you can still do better");
            else if (length >= 16)
                System.out.println("This is a great password :)");
            else if (length < 8)
                System.out.println("This is a medium password :) try making it better");
        } else if(n == 3) {
            if (length >= 8) 
            System.out.println("This is a good password :/ but you can still do better");
            else if (length >= 16)
            System.out.println("This is a great password :)");
            else if (length < 8)
            System.out.println("This is a medium password :) try making it better");
            
        } else {
            if (length >= 8) 
                System.out.println("This is a medium password :/ try making it better");
            else if (length >= 16)
                System.out.println("This is a good password :/ but you can still do better");
            else  
                System.out.println("This is a weak password :( definitely find a new one");
        }
        System.out.println();
    }

} 
