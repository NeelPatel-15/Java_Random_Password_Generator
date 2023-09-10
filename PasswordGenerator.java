import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {

        System.out.println("++++++++++++++ RULES TO GENERATE PASSWORD ++++++++++++++");
        System.out.println("To stay more secure, your password must be at least 7 Characters long. ");
        System.out.println("Your password must include letter, number, and special character.");
        System.out.println("++++++++++++++ +++++++++++++++++++++++++ ++++++++++++++\n");



        boolean stayContinue = true;
        while (stayContinue){
            System.out.println("Please choose 1 or 2.");
            System.out.println("1. You generate your own password!");
            System.out.println("2. Let me generate your password!");
            Scanner scan = new Scanner(System.in);
            int userNumber = scan.nextInt(); //IF you provide a string instead of numeric, you will get Error
            switch (userNumber){
                case 1:
                    userGenerate();
                    stayContinue = false;
                    break;
                case 2:
                    autoGenerate();
                    stayContinue = false;
                    break;
                default:
                    stayContinue = true;
            }

        }

    }

    public static void userGenerate(){

        Scanner scan = new Scanner(System.in);

        boolean runAgain = true;
        while (runAgain){
            System.out.println("Type a string that you want to add in your password: ");
            String userString = scan.nextLine();

            System.out.println("Type a numbers that you want to add in your password: ");
            String userNumbers = scan.nextLine();

            System.out.println("Type a string that you want to add in your password: ");
            String userSpecialCharacter= scan.nextLine();

            int totalLen = userString.length() + userNumbers.length() + userSpecialCharacter.length();
            if (totalLen < 7){
                System.out.println("++++++++++++++++++++ Your password must be atleast 7 characters long. +++++++++++++++++++++");
                runAgain = true;
            }
            else {
                runAgain = false;
                String allCharacters = userString + userNumbers + userSpecialCharacter;


                // Convert the string into a character array
                char[] charArray = allCharacters.toCharArray();

                // Shuffle the character array
                shuffleArray(charArray);

                // Create a new string from the shuffled character array
                String shuffledString = new String(charArray);

                System.out.println("Here is your password >>>>>>>>>>>>>>>>>>>>> " + shuffledString);
            }
        }
    }

    public static void shuffleArray(char[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void autoGenerate() {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

        // Create a secure random number generator
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder(10);

        int min = 7; // Minimum value (inclusive)
        int max = 17; // Maximum value (exclusive)

        Random randomAuto = new Random();
        int randomNumber = randomAuto.nextInt(max - min) + min;

        // Generate the password by randomly selecting characters from allowedCharacters
        for (int i = 0; i < randomNumber; i++) {
            int randomIndex = randomAuto.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        System.out.println("Here is your password >>>>>>>>>>>>>>>>>>>>> " + password);
    }

}
