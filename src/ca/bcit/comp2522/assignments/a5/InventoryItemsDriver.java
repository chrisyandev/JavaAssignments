package ca.bcit.comp2522.assignments.a5;

import java.util.Date;

public class InventoryItemsDriver {

    public static InventoryItem[] inventory = {
            new RentalItem(new Date(2020, 1, 1), 12345L, "A comic book.", "Comic Book", 9.99, "Book", Condition.AVERAGE, 111L, 2.99),
            new RentalItem(new Date(2020, 1, 1), 12345L, "A comic book.", "Comic Book", 9.99, "Book", Condition.GREAT, 222L, 2.99),
            new RentalItem(new Date(2020, 1, 1), 12345L, "A comic book.", "Comic Book", 9.99, "Book", Condition.DAMAGED, 333L, 2.99)
    };

    public static void main(final String[] args) {
        SalesItem comic = new SalesItem(new Date(2020, 1, 1), 12345L, "A comic book.", "Comic Book", 9.99, "Book", 19.99, 101L);
        System.out.println(comic);

        Rental rental = new Rental("No comments", new Date(2020, 1, 1), 222L);
        System.out.println(rental.getConditionAfter());
        System.out.println(((RentalItem) inventory[1]).getItems()[0].getComments());
    }
}
