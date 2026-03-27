import java.util.*;
import java.util.stream.*;

// Passenger Bogie class
class PassengerBogie {
    String type; // e.g., Sleeper, AC Chair
    int capacity;

    PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public void display() {
        System.out.println(type + " -> Capacity: " + capacity);
    }
}

public class TRAINCONSISTMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("===== Train Consist Management App (UC9) =====");

        // Step 1: Create list
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));
        bogies.add(new PassengerBogie("First Class", 24));
        bogies.add(new PassengerBogie("Sleeper", 60));
        bogies.add(new PassengerBogie("AC Chair", 50));

        // Step 2: Group by type using Stream
        Map<String, List<PassengerBogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // Step 3: Display grouped result
        System.out.println("Bogies grouped by type:");
        for (String type : groupedBogies.keySet()) {
            System.out.println("\n" + type + " Bogies:");
            groupedBogies.get(type).forEach(PassengerBogie::display);
        }

        System.out.println("\nProgram continues...");
    }
}