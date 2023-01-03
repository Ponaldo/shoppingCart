import java.util.HashMap;
import java.util.Scanner;

public class ShopCart {

    private static HashMap<String, Integer> items = new HashMap<String, Integer>();
    public static void printItems(HashMap x){
        for(Object i : x.keySet()){
            System.out.println(i + " - " + x.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("Here is the shopping cart, use the following options:");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. Update an item");
            System.out.println("4. Print the list of items");
            System.out.println("5. Exit the shopping cart");
            choice = kbReader.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Enter the name of your item:");
                    String itemName = kbReader.next();
                    System.out.println("Enter the amount of your item: ");
                    Integer itemAmt = kbReader.nextInt();
                    items.put(itemName, itemAmt);
                    break;
                case 2:
                    System.out.println("Enter the name of the item you want to remove: ");
                    String removal;
                    removal = kbReader.next();
                    Object retVal = items.remove(removal);
                    if(retVal == null) System.out.println("This item is not in your shopping cart.");
                    break;
                case 3:
                    System.out.println("Enter the name of the item whose value you want to update: ");
                    String update = kbReader.next();
                    System.out.println("Enter what you want to change the value to: ");
                    Integer changeValue = kbReader.nextInt();
                    if (items.get(update) == null) {
                        System.out.println("This item has not been added to your cart, please go to the menu and select 1.");
                    } else {
                        items.put(update, changeValue);
                    }
                    break;
                case 4:
                    printItems(items);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Please enter a number from 1-5.");
                    break;
            }
        }
    }
}