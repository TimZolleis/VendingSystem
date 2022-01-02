import java.util.*;

public class Inventory {
    private String type;
    private int quantity;
    final static HashMap<String, Integer> inventories = new HashMap<>();

    public Inventory() {
    }

    public Inventory(String type, int quantity) {
        this.type = type;
        this.quantity = inventories.get(type);
    }

    public int getQuantity() {
        return quantity;
    }

    public HashMap<String, Integer> display() {
        return inventories;
    }

    public String getType() {
        return type;
    }

    public void create(String type, Integer quantity) {
        //check if inventory already contains given type
        if (inventories.containsKey(type))
            System.out.println("Already existent!");
        else {
            inventories.put(type, quantity);
            System.out.println(quantity + type + "added successfully!");
        }
    }

    public void add(String type, int addQuantity) {
        //check if given type exists
        if (!inventories.containsKey(type))
            System.out.println("Error! Non-existent");
        else {
            inventories.put(type, inventories.get(type) + addQuantity);
            if (getQuantity() < 2 && !type.endsWith("s")) //adding "s" to plural
                System.out.println(addQuantity + " " + type + " added successfully! You now have " + getQuantity() + " " + type);
            else if (!type.endsWith("s"))
                System.out.println(addQuantity + " " + type + "s" + " added successfully! You now have " + getQuantity() + " " + type);

        }
    }

    public void sell(String type, int removeQuantity) {
        //check if exists
        if (inventories.containsKey(type)) {
            System.out.println("Step 1 Success!");
            if (inventories.get(type) >= removeQuantity) {
                System.out.println("Step 2 success!");
                inventories.put(type, inventories.get(type) - removeQuantity);
                System.out.println(removeQuantity + " " + type + " sold successfully!");
                if (getQuantity() < 2 && !type.endsWith("s")) //adding "s" to plural
                    System.out.println("There is only " + getQuantity() + " " + type + " left");
                else if (!type.endsWith("s"))
                    System.out.println("There are" + getQuantity() + "s " + type + " left!");
            }
            else System.out.println("error! Not enough inventory! There are only " + getQuantity() + " " + type  + " left!");
        }
        else System.out.println("error! non-existent");
    }

    public String determineType() {
        Scanner scanner = VendingSystemApp.scanner;
        System.out.print("Type: ");
        return scanner.nextLine();
    }

    public int determineQuantity() {
        Scanner scanner = VendingSystemApp.scanner;
        System.out.print("Quantity: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Quantity: " + getQuantity() + "\n" +
                "Type: " + getType();
    }
}
