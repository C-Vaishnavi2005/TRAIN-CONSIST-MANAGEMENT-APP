import java.util.*;
import java.util.stream.*;

// Goods Bogie class
class GoodsBogie {
    String shape;     // Rectangular or Cylindrical
    String cargo;     // type of cargo

    GoodsBogie(String shape, String cargo) {
        this.shape = shape;
        this.cargo = cargo;
    }

    public void display() {
        System.out.println(shape + " bogie carrying: " + cargo);
    }
}

public class TRAINCONSISTMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("===== Train Consist Management App (UC12) =====");

        // Step 1: Create list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Milk"));  // valid liquid
        goodsBogies.add(new GoodsBogie("Rectangular", "Steel"));

        // Step 2: Safety compliance check using Stream + allMatch
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    // Cylindrical bogie must carry liquid cargo only
                    if (b.shape.equals("Cylindrical")) {
                        return b.cargo.equalsIgnoreCase("Petroleum") || b.cargo.equalsIgnoreCase("Milk") || b.cargo.equalsIgnoreCase("Oil");
                    }
                    // Rectangular can carry any other cargo
                    return true;
                });

        // Step 3: Display results
        System.out.println("Goods bogie details:");
        goodsBogies.forEach(GoodsBogie::display);

        if (isSafe) {
            System.out.println("All goods bogies comply with safety rules. Train is safe!");
        } else {
            System.out.println("Safety violation detected! Train formation is unsafe!");
        }

        System.out.println("Program continues...");
    }
}