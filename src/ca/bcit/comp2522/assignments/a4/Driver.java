package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        BookStoreFactory bsf = BookStoreFactory.getInstance();
        bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
    }
}
