package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class BookStoreFactory {

    public BookStoreFactory() {

    }

    public class Book { // TODO: Change to private

        private final Element bookElement;
        private final String isbn;
        private final String year;
        private final String edition;
        private final String name;
        private final String description;
        private final ArrayList<Course> courses;
        private final ArrayList<Author> authors;
        private final String publisher;
        private final Price price;
        private final Stock stock;

        public Book(Node bookItem) {
            courses = new ArrayList<>();
            authors = new ArrayList<>();
            bookElement = (Element) bookItem;

            isbn = bookElement.getAttribute("isbn");
            year = bookElement.getAttribute("year");
            edition = bookElement.getAttribute("edition");

            name = bookElement
                    .getElementsByTagName("name")
                    .item(0)
                    .getTextContent();

            description = bookElement
                    .getElementsByTagName("description")
                    .item(0)
                    .getTextContent();

            NodeList courseList = bookElement.getElementsByTagName("course");
            for (int i = 0; i < courseList.getLength(); i++) {
                courses.add(new Course(courseList.item(i)));
            }

            NodeList authorList = bookElement.getElementsByTagName("author");
            for (int i = 0; i < authorList.getLength(); i++) {
                authors.add(new Author(authorList.item(i)));
            }

            publisher = bookElement
                    .getElementsByTagName("publisher")
                    .item(0)
                    .getTextContent();

            Node priceItem = bookElement.getElementsByTagName("price").item(0);
            price = new Price(priceItem);

            stock = new Stock();
        }

        private class Stock {
            private String category;
            private int copiesInStock;
            private String coverImageURL;
            private int availabilityDays;

            public Stock() {
                category = bookElement
                        .getElementsByTagName("category")
                        .item(0)
                        .getTextContent();
                copiesInStock = Integer.parseInt(bookElement
                        .getElementsByTagName("copiesinstock")
                        .item(0)
                        .getTextContent());
                coverImageURL = bookElement
                        .getElementsByTagName("coverimage")
                        .item(0)
                        .getAttributes()
                        .getNamedItem("url")
                        .getTextContent();
                availabilityDays = Integer.parseInt(bookElement
                        .getElementsByTagName("availability")
                        .item(0)
                        .getAttributes()
                        .getNamedItem("days")
                        .getTextContent());
            }

            public String toString() {
                return "category: " + category
                        + "\ncopiesInStock: " + copiesInStock
                        + "\ncoverImageURL: " + coverImageURL
                        + "\navailabilityDays: " + availabilityDays;
            }
        }

        private class Course {
            private String name;
            private String institute;

            public Course(Node courseItem) {
                name = courseItem.getTextContent();
                NamedNodeMap courseAttr = courseItem.getAttributes();
                institute = courseAttr.getNamedItem("institute").getTextContent();
            }

            public String toString() {
                return name + " | " + institute;
            }
        }

        private class Author {
            private String firstName;
            private String lastName;

            public Author(Node authorItem) {
                NamedNodeMap authorAttr = authorItem.getAttributes();
                firstName =
                        authorAttr.getNamedItem("firstname").getTextContent();
                lastName =
                        authorAttr.getNamedItem("lastname").getTextContent();
            }

            public String toString() {
                return firstName + " " + lastName;
            }
        }

        private class Price {
            private String currency;
            private float value;

            public Price(Node priceItem) {
                NamedNodeMap priceAttr = priceItem.getAttributes();
                currency = priceAttr.getNamedItem("currency").getTextContent();
                value = Float.parseFloat(priceItem.getTextContent());
            }

            public String toString() {
                return "currency: " + currency + "\nvalue: " + value;
            }
        }

        public String toString() {
            String out = "name: " + name
                    + "\ndescription: " + description
                    + "\nisbn: " + isbn
                    + "\nyear: " + year
                    + "\nedition: " + edition
                    + "\npublisher: " + publisher
                    + "\n- price -\n" +  price
                    + "\n- stock -\n" + stock;
            out += "\n--- Courses ---";
            for (Course c : courses) {
                out += "\n";
                out += c;
            }
            out +="\n--- Authors ---";
            for (Author a : authors) {
                out += "\n";
                out += a;
            }
            return out;
        }
    }

    public Document getDOM(String fileName) {
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
