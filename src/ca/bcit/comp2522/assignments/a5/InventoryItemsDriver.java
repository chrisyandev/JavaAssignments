package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * InventoryItemsDriver. Creates InventoryItem objects and uses their methods.
 *
 * @author Chris Yan
 * @version 2020
 */
public class InventoryItemsDriver {

    /** List of all items in stock. */
    public static ArrayList<InventoryItem> inventory = new ArrayList<>();

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        addSalesItem(2020, 10, 1, 68432L, "An English dictionary.",
                "Oxford Dictionary", 40.00, "Book", 69.45);
        addSalesItem(2020, 10, 1, 68432L, "An English dictionary.",
                "Oxford Dictionary", 40.00, "Book", 69.45);
        addSalesItem(2019, 12, 17, 49211L, "A first-person shooter",
                "The Soldier", 35.00, "Game", 56.99);
        addRentalItem(2019, 1, 1, 12345L, "A comic book.", "Dash",
                20.00, "Book", Condition.AVERAGE, 2.99);
        addRentalItem(2020, 2, 23, 76893L, "A movie on vampires.",
                "Vampire Love", 40.00, "Movie", Condition.EXCELLENT, 4.99);
        addRentalItem(2017, 5, 8, 19267L, "A role-playing game.",
                "Ultimate RPG", 70.00, "Game", Condition.DAMAGED, 7.99);
        addRentalItem(2017, 5, 8, 19267L, "A role-playing game.",
                "Ultimate RPG", 70.00, "Game", Condition.DAMAGED, 7.99);

        removeDuplicates();
        printInventory();
    }

    /**
     * Adds a sales item.
     * @param purchaseYear year purchased
     * @param purchaseMonth month purchased
     * @param purchaseDay day purchased
     * @param SKU unique item identifier
     * @param desc item description
     * @param name item name
     * @param purchasePrice price purchased
     * @param type type of item
     * @param salePrice selling price
     */
    public static void addSalesItem(final int purchaseYear,
                                    final int purchaseMonth,
                                    final int purchaseDay,
                                    final long SKU,
                                    final String desc,
                                    final String name,
                                    final double purchasePrice,
                                    final String type,
                                    final double salePrice) {
        inventory.add(new SalesItem(
                new Date(purchaseYear - 1900, purchaseMonth, purchaseDay),
                SKU, desc, name, purchasePrice, type, salePrice));
    }

    /**
     * Adds a rental item.
     * @param purchaseYear year purchased
     * @param purchaseMonth month purchased
     * @param purchaseDay day purchased
     * @param SKU unique item identifier
     * @param desc item description
     * @param name item name
     * @param purchasePrice price purchased
     * @param type type of item
     * @param condition condition of item
     * @param rentalPrice cost to rent
     */
    public static void addRentalItem(final int purchaseYear,
                                    final int purchaseMonth,
                                    final int purchaseDay,
                                    final long SKU,
                                    final String desc,
                                    final String name,
                                    final double purchasePrice,
                                    final String type,
                                    final Condition condition,
                                    final double rentalPrice
                                    ) {
        inventory.add(new RentalItem(
                new Date(purchaseYear - 1900, purchaseMonth, purchaseDay),
                SKU, desc, name, purchasePrice, type, condition, rentalPrice));
    }

    /**
     * Removes a specific item from the inventory based on SKU.
     * @param SKU a unique item identifier
     */
    public static void removeItem(final long SKU) {
        Iterator<InventoryItem> inventoryIterator = inventory.iterator();
        while (inventoryIterator.hasNext()) {
            InventoryItem item = inventoryIterator.next();
            if (item.getSKU() == SKU) {
                System.out.println("Removed: " + item.getSKU()
                        + " | " + item.getName());
                inventoryIterator.remove();
            }
        }
    }

    /**
     * Makes sure every item in the inventory is unique by
     * removing all equal items except one.
     */
    public static void removeDuplicates() {
        ArrayList<Integer> removeIndices = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = i + 1; j < inventory.size(); j++) {
                if (inventory.get(j).equals(inventory.get(i))) {
                    removeIndices.add(j);
                }
            }
        }
        Iterator<InventoryItem> inventoryIterator = inventory.iterator();
        int index = 0;
        while (inventoryIterator.hasNext()) {
            InventoryItem item = inventoryIterator.next();
            if (removeIndices.contains(index)) {
                System.out.println("Removed: " + item.getSKU()
                        + " | " + item.getName());
                inventoryIterator.remove();
            }
            index++;
        }

        System.out.println("Finished removing duplicates");
    }

    /** Formats and prints the inventory list. */
    public static void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("--- " + (i + 1) + " ---");
            System.out.println(inventory.get(i));
        }
    }
}
