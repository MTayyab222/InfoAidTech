import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: User input - decide on the length of the password
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();

        // Step 2: User input - decide on the character set
        System.out.print("Enter the character set (1 for lowercase, 2 for uppercase, 3 for numbers, 4 for special characters, combine with no spaces): ");
        String characterSetChoice = scanner.next();

        // Step 3: Generate the password
        String password = generatePassword(passwordLength, characterSetChoice);

        // Step 4: Display the generated password
        System.out.println("Generated Password: " + password);

        // Close the scanner
        scanner.close();
    }

    // Step 5: Create a function to generate the password
    private static String generatePassword(int length, String characterSetChoice) {
        StringBuilder password = new StringBuilder();
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_+=<>?/";

        String characterSet = "";

        // Build the character set based on user choice
        if (characterSetChoice.contains("1")) {
            characterSet += lowercaseLetters;
        }
        if (characterSetChoice.contains("2")) {
            characterSet += uppercaseLetters;
        }
        if (characterSetChoice.contains("3")) {
            characterSet += numbers;
        }
        if (characterSetChoice.contains("4")) {
            characterSet += specialCharacters;
        }

        // Step 6: Use random number generation to generate the password
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        // Step 7: Convert the password to a string and return it
        return password.toString();
    }
}
