package out;

import java.util.*;

public class Generate {
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
        char arr_symbols[] = {'!', '@', '#', '$', '%', '^','&'};  
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