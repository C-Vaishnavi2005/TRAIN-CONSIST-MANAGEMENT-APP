import java.util.Scanner;
import java.util.regex.*;

public class TRAINCONSISTMANAGEMENTAPP {

    // Method to validate Train ID
    public static boolean validateTrainID(String trainID) {
        // Regex: TRN- followed by 4 digits
        String regex = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // Method to validate Cargo Code
    public static boolean validateCargoCode(String cargoCode) {
        // Regex: CG-[A-Z]{3}-\d{2} (example: CG-BOX-12)
        String regex = "CG-[A-Z]{3}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Train Consist Management App (UC11) =====");

        // Step 1: Get Train ID
        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainID = sc.nextLine();
        if (validateTrainID(trainID)) {
            System.out.println("Train ID accepted: " + trainID);
        } else {
            System.out.println("Invalid Train ID format!");
        }

        // Step 2: Get Cargo Code
        System.out.print("Enter Cargo Code (format CG-XXX-12): ");
        String cargoCode = sc.nextLine();
        if (validateCargoCode(cargoCode)) {
            System.out.println("Cargo Code accepted: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code format!");
        }

        System.out.println("Program continues...");
        sc.close();
    }
}