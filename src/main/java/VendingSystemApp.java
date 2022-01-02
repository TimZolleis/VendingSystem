import java.util.*;

public class VendingSystemApp {
    private final static String user = "admin";
    private final static String pw = "123456";
    public final static Scanner scanner = new Scanner(System.in);
    final static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        selection();
        //get current inventory
        //sell stuff
        //import stuff
        //quit

    }

    private static void login() {
        while (true) {
            System.out.print("username:");
            String enteredUsername = scanner.nextLine();
            if (enteredUsername.equals(user))
                break;
            System.out.println("Incorrect username!");
        }
        while (true) {
            System.out.print("password:");
            String enteredPassword = scanner.nextLine();
            if (enteredPassword.equals(pw))
                break;
            System.out.println("Incorrect password!");
            selection();

        }
    }

    private static void selection() {
        boolean exit = false;
        String command;
        inventory.create("Apples", 100);
        inventory.create("Bananas", 200);
        System.out.println(inventory.display());
        while (!exit) {
            System.out.println("Enter command ( 1 create,  2 add,  3 sell,  4 save,  5 display,  6 quit");
            command = scanner.nextLine();
            switch (command) {
                case "create" -> {
                    System.out.println("Creating inventory:");
                    inventory.create(inventory.determineType(), inventory.determineQuantity());
                }
                case "add" -> {
                    System.out.println("Adding inventory:");
                    inventory.add(inventory.determineType(), inventory.determineQuantity());
                }
                case "sell" -> {
                    System.out.println("Selling inventory:");
                    inventory.sell(inventory.determineType(), inventory.determineQuantity());
                }
                case "save" -> System.out.println("Saving...");
                case "display" -> {
                    System.out.println("Displaying Inventory");
                    System.out.println(inventory.display());
                }
                case "quit" -> {
                    System.out.println("Bye!");
                    exit = true;
                }
            }
        }


    }
}
