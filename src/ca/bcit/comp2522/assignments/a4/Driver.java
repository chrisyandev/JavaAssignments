package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Driver {
    public static void main(String[] args) {
        BookStoreFactory bsf = new BookStoreFactory();
        Document doc = bsf.getDOM("bookstore.xml");
        Node bookItem = doc.getElementsByTagName("book").item(0);
        BookStoreFactory.Book book = bsf.new Book(bookItem);
        System.out.println(book);
    }
}
