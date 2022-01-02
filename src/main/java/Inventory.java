import java.util.*;

public class Inventory {
    private String type;
    private double quantity;
    final static HashMap<String, Double> inventories = new HashMap<>();

    public Inventory() {
    }

    public Inventory(String type, double quantity) {
        this.type = type;
        this.quantity = inventories.get(type);
    }

    public double getQuantity() {
        return quantity;
    }

    public HashMap<String, Double> display() {
        return inventories;
    }

    public String getType() {
        return type;
    }

    public void create(String type, double quantity) {
        //check if inventory already contains given type
        if (inventories.containsKey(type))
            System.out.println("Already existent!");
        else {
            inventories.put(type, quantity);
            System.out.println(quantity + type + "added successfully!");
        }
    }

    public void add(String type, double addQuantity) {
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

    public void sell(String type, double removeQuantity) {
        //check if exists
        if (inventories.containsKey(type)) {
            //check if enough is there
            if (inventories.get(type) > removeQuantity) {
                //sell
                inventories.put(type, inventories.get(type) - removeQuantity);
                System.out.println(removeQuantity + " " + type + " sold successfully!");
                if (getQuantity() < 2 && !type.endsWith("s")) //adding "s" to plural
                    System.out.println("There is only " + getQuantity() + " " + type + " left");
                else if (!type.endsWith("s"))
                    System.out.println("There are" + getQuantity() + "s " + type + " left!");
            }
        }
    }

    public String determineType() {
        Scanner scanner = VendingSystemApp.scanner;
        System.out.print("Type: ");
        return scanner.nextLine();
    }

    public double determineQuantity() {
        Scanner scanner = VendingSystemApp.scanner;
        System.out.print("Quantity: ");
        return scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Quantity: " + getQuantity() + "\n" +
                "Type: " + getType();
    }
}
