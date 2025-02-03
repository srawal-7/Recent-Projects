//Name: Shriya Rawal
//Date: 11/01/2024

//Import Scanner and Random classes
import java.util.Scanner;
import java.util.Random;

//The main function will host the entire code and result in an interactive password generator for my users
//The users will be able to choose between a weak, medium or strong password and each time, the main function will display a randomly generated password
public class Main {
    public static void main(String[] args) {
        // Declare variables
        String letters_medium; //store lower case letters (& numbers) for medium password options
        String letters_strong; //store letters, numbers and other characters for strong password options
        String password; // store user input for strength of password
        String satisfied = "No"; // initiating it to No
        int pick_enum_value; // store the random value picked from my enum
        int length; // store the length of password to be generated

        //Initiate Scanner and Random classes to get user input and generate random passwords respectively
        Random random = new Random();
        Scanner passwords = new Scanner(System.in);

        //Given the limited number of weak password options, using an enum to store them looks like an efficient approach.
        //The weakPass enum contains eight weak passwords consisting solely of letters and will be used to randomly generate a word within my conditional statement
        //When the user selects the "weak" password option
        enum weakPass {blueapron, pinkphone, flowergrace, fallball, greatpancake, beachball, leatherhat, northglaze}

        // Assign letters_medium and letters_strong variables necessary letters/numbers/characters
        letters_medium = "abcdefghijklmnopqrstuvwxyz0123456789";
        letters_strong = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

        System.out.println("Hello! This is a password generator. "); //Printing an initial hello message to greet the user

        // Ask user for their password preference and store in "password" variable
        // using a do while loop to make sure my statement gets a chance to run if the user chooses the correct password strength before the loop starts
        // and if the user enters an invalid option, the while loop can keep asking for the correct choice
        do {
            System.out.println("What kind of password would you like to generate? Please select either weak, medium or strong: ");
            password = passwords.next().toLowerCase();

            if ((!password.equals("weak") && !password.equals("medium") && !password.equals("strong"))) {
                // Last else statement will just be a default option in case the user types something other than "weak", "medium" or "strong"
                System.out.println("Invalid option! Please choose either weak, medium or strong to generate a password!");
            }

        } while ((!password.equals("weak") && !password.equals("medium") && !password.equals("strong")));

        // While loop will keep going until the user says "yes" for being satisfied, currently set to "no"
        // It is required so that the program can keep asking the user whether they want a new password if they are not satisfied with the result that the program generated
        while (!satisfied.equals("yes")) {
            //Conditional statement for user to choose a weak, medium or strong password.
            // Pick a value from enum and keep printing new value until the user is satisfied
            switch (password) {
                case "weak" -> {
                    pick_enum_value = random.nextInt(weakPass.values().length);
                    System.out.println("Here is your password: " + weakPass.values()[pick_enum_value]);
                    System.out.println("Are you satisfied with the output? (yes/no)");
                    satisfied = passwords.next().toLowerCase(); // this way any variation of "yes" will work
                }

                // Using charAt and random.NextInt to generate random characters as informed by professor Faustin and TA Saivinay via project1 Check in
                // If the user selects medium password, then the program will ask the user how long of a password they want
                case "medium" -> {
                    System.out.println("How long would you like your password to be? (Please pick between 10-16 characters) ");
                    length = passwords.nextInt();
                    if (length >= 10 && length <= 16) {
                        // The for loop will keep generating a random character until it prints out a string of characters that matches
                        // the length provided by the user
                        for (int i = 0; i < length; i++) {
                            System.out.print(letters_medium.charAt(random.nextInt(letters_medium.length())));
                        }
                        System.out.println();
                        System.out.println("Are you satisfied with the output? (yes/no)");
                        satisfied = passwords.next().toLowerCase();
                    } else {
                        System.out.println("Invalid option! Please choose a length between 10-16 characters");
                    }
                }
                // the code for strong password is the same as medium password generation, but in this case, the for loop refers to the
                // strong_letter variable instead of medium_letter variable
                case "strong" -> {
                    System.out.println("How long would you like your password to be? (Please pick between 10-16 characters) ");
                    length = passwords.nextInt();
                    if (length >= 10 && length <= 16) {
                        for (int i = 0; i < length; i++) {
                            System.out.print(letters_strong.charAt(random.nextInt(letters_strong.length())));
                        }
                        System.out.println();
                        System.out.println("Are you satisfied with the output? (yes/no)");
                        satisfied = passwords.next().toLowerCase();
                    } else {
                        System.out.println("Invalid option! Please choose a length between 10-16 characters");
                    }
                }
            }
        }
    }
}
