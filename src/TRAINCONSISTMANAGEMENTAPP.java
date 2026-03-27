import java.util.*;
import java.util.stream.*;

// Passenger Bogie class
class PassengerBogie {
    String type;
    int capacity;

    PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        System.out.println(type + " -> Capacity: " + capacity);
    }
}

public class TRAINCONSISTMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("===== Train Consist Management App (UC10) =====");

        // Step 1: Create list of passenger bogies
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));
        bogies.add(new PassengerBogie("First Class", 24));
        bogies.add(new PassengerBogie("Sleeper", 60));
        bogies.add(new PassengerBogie("AC Chair", 50));

        // Step 2: Compute total seats using Stream + reduce
        int totalSeats = bogies.stream()
                .map(PassengerBogie::getCapacity)   // extract capacity
                .reduce(0, Integer::sum);           // sum all capacities

        // Step 3: Display total seating capacity
        System.out.println("Total seating capacity of the train: " + totalSeats);

        System.out.println("Program continues...");
    }
}