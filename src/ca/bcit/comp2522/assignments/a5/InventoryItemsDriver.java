package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class InventoryItemsDriver {

    public static ArrayList<InventoryItem> inventory = new ArrayList<>();

    public static void main(final String[] args) {
        inventory.add(new RentalItem(new Date(2019, 1, 1),
                12345L, "A comic book.", "Dash", 20.00,
                "Book", Condition.AVERAGE, 2.99));
        inventory.add(new RentalItem(new Date(2020, 2, 23),
        76893L, "A movie on vampires.", "Vampire Love", 40.00,
                "Movie", Condition.EXCELLENT, 4.99));
        inventory.add(new RentalItem(new Date(2017, 5, 8),
                19267L, "A role-playing game.", "Ultimate RPG",
                70.00, "Game", Condition.DAMAGED, 7.99));
        inventory.add(new SalesItem(new Date(2020, 10, 1), 68432L,
                "An English dictionary.", "Oxford Dictionary",
                40.00, "Book", 69.45));
        inventory.add(new SalesItem(new Date(2019, 12, 17), 49211L,
                "A first-person shooter", "The Soldier",
                35.00, "Game", 56.99));

        RentalItem rentalItem = (RentalItem) inventory.get(0);
        rentalItem.setItems(new Rental[] { new Rental("Was accidentally dropped.", new Date(2020, 10, 1), 101L) });
        System.out.println(Arrays.toString(rentalItem.getItems()));

    }
}
