import java.util.ArrayList;
import java.util.List;

// Step 1: Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie class with capacity validation
class PassengerBogie {
    String type;
    int capacity;

    // Constructor validates capacity
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for " + type + ": " + capacity);
        }
        this.type = type;
        this.capacity = capacity;
    }

    public void display() {
        System.out.println(type + " bogie with capacity: " + capacity);
    }
}

public class TRAINCONSISTMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("===== Train Consist Management App (UC14) =====");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            // Valid bogie
            bogies.add(new PassengerBogie("Sleeper", 72));

            // Invalid bogie → should throw exception
            bogies.add(new PassengerBogie("AC Chair", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Continue safely with valid bogies
        System.out.println("Valid bogies in the train:");
        bogies.forEach(PassengerBogie::display);

        System.out.println("Program continues safely...");
    }
}