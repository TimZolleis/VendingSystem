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
        int command;
        System.out.println(inventory.display());
        while (!exit) {
            System.out.println("Enter command ( 1 create,  2 add,  3 sell,  4 save,  5 display,  6 quit");
            command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    System.out.println("Creating inventory:");
                    inventory.create(inventory.determineType(), inventory.determineQuantity());
                    System.out.println("Do you want to quit? (Yes/No)");
                    if (scanner.next().equalsIgnoreCase("Yes"))
                        exit = true;
                    break;
                case 2:
                    System.out.println("Adding inventory:");
                    inventory.add(inventory.determineType(), inventory.determineQuantity());
                    System.out.println("Do you want to quit? (Yes/No)");
                    if (scanner.next().equalsIgnoreCase("Yes"))
                        exit = true;
                    break;
                case 3:
                    System.out.println("Selling inventory:");
                    inventory.sell(inventory.determineType(), inventory.determineQuantity());
                    System.out.println("Do you want to quit? (Yes/No)");
                    if (scanner.next().equalsIgnoreCase("Yes"))
                        exit = true;
                    break;
                case 4:
                    System.out.println("Saving...");
                    break;
                case 5:
                    System.out.println("Displaying Inventory");
                    inventory.display();
                    break;
                case 6:
                    System.out.println("Bye!");
                    exit = true;
                    break;
            }
        }


    }
}
