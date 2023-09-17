import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();

        if (passwordLength <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        scanner.nextLine(); // Consume the newline character

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");

        String password = generatePassword(passwordLength, includeUppercase, includeLowercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        String allChars = "";

        if (includeUppercase) {
            allChars += uppercaseChars;
        }
        if (includeLowercase) {
            allChars += lowercaseChars;
        }
        if (includeDigits) {
            allChars += digitChars;
        }
        if (includeSpecialChars) {
            allChars += specialChars;
        }

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}