
import java.util.*;


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

class Generate {
    public static char[] get_arr(int start, int end) {
        char[] arr = new char[end-start];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (char)(start + i);
        }
        return arr;
    }

    


    Scanner sc;
    Random random;
    public Generate(Scanner sc, Random random) {
        this.sc = sc;
        this.random = random;
    }
    public void user_questions() {
        char arr_lower_alpha[] = new char[26];
        char arr_upper_alpha[] = new char[26];
        char arr_numbers[] = new char[10];
        char arr_symbols[] = {'!', '@', '#', '$', '%', '^','&'};  //Add more symbols if needed
        String password = "";
        String final_password = "";
        System.out.println("\nHello, welcome to the Password Generator :) answer the following questions by Yes or No\n");
        while (true) {
            System.out.println("Do you want LowerCase Letters \"abcd...\" to be used?");
            String q1 = sc.next().toLowerCase();
            arr_lower_alpha = (q1.equals("yes"))?get_arr(97, 123):arr_lower_alpha;
            System.out.println("Do you want UpperCase Letters \"ABCD...\" to be used?");
            String q2 = sc.next().toLowerCase();
            arr_upper_alpha = (q2.equals("yes"))?get_arr(65, 91):arr_upper_alpha;
            System.out.println("Do you want Numbers \"1234...\" to be used?: ");
            String q3 = sc.next().toLowerCase();
            arr_numbers = (q3.equals("yes"))?get_arr(48, 58):arr_numbers;
    
            System.out.println("Do you want Symbols \"!@#$...\" to be used?: ");
            String q4 = sc.next().toLowerCase();
            if ((q1.equals("yes"))||(q2.equals("yes"))||(q3.equals("yes")) || (q4.equals("yes"))) {
                System.out.println("Great! Now enter the length of the password");
                int q5 = sc.nextInt();
                while (password.length()<q5 ) {                        
                    password = (q1.equals("yes")&&password.length()<q5)?(password + Character.toString(arr_lower_alpha[random.nextInt(arr_lower_alpha.length)])):password+"100";
                    password = (q2.equals("yes")&&password.length()<q5)?(password + Character.toString(arr_upper_alpha[random.nextInt(arr_upper_alpha.length)])):password;
                    password = (q3.equals("yes")&&password.length()<q5)?(password + (arr_numbers[random.nextInt(arr_numbers.length)])):password;
                    password = (q4.equals("yes")&&password.length()<q5)?(password + (arr_symbols[random.nextInt(arr_symbols.length)])):password;
                    // System.out.println(password.length());
                } 
                break;
            }
            else {
                System.out.println("You have selected no characters to generate your passwod, at least one of your answers should be Yes\n");
            }

        }

        

        // System.out.println(Arrays.toString(arr_lower_alpha));
        // System.out.println(Arrays.toString(arr_upper_alpha));
        // System.out.println(Arrays.toString(arr_numbers));
        // System.out.println(Arrays.toString(arr_symbols));
        // System.out.println(password);
        char final_arr[] = password.toCharArray();
        ArrayList<Integer> dub = new ArrayList<>();
        
        int random_index;
        int i=0;
        while (i<password.length()) {
            random_index = random.nextInt(final_arr.length);
            if (dub.contains(random_index) == true) {
                // System.out.println(dub);
                continue;
            } 
            dub.add(random_index);
            final_arr[random_index] = (password.charAt(i));
            i += 1;
        }
        
        for (char j:final_arr) {
            final_password+=j;
        }
        System.out.println(String.join(" -> ", "Your generated password", final_password + "\n"));
    }
}
class Strength {
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
class Info {
    public void getInfo() {
        System.out.println("Use a minimum password length of 8 or more characters if permitted\r\n" + //
                            "Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted\r\n" + //
                            "Generate passwords randomly where feasible\r\n" + //
                            "Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)\r\n" + //
                            "Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\r\n" + //
                            "usernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).\r\n" + //
                            "Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user\r\n" + //
                            "Do not use passwords which consist wholly of any simple combination of the aforementioned weak components\r\n");
    }
}