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

        private String name;
        private String description;
        private ArrayList<Course> courses;
        private ArrayList<Author> authors;

        public Book(Node bookItem) {
            courses = new ArrayList<>();
            authors = new ArrayList<>();
            Element bookElement = (Element) bookItem;

            Node nameItem = bookElement.getElementsByTagName("name").item(0);
            name = nameItem.getTextContent();

            Node descriptionItem =
                    bookElement.getElementsByTagName("description").item(0);
            description = descriptionItem.getTextContent();

            NodeList courseList = bookElement.getElementsByTagName("course");
            for (int i = 0; i < courseList.getLength(); i++) {
                courses.add(new Course(courseList.item(i)));
            }

            NodeList authorList = bookElement.getElementsByTagName("author");
            for (int i = 0; i < authorList.getLength(); i++) {
                authors.add(new Author(authorList.item(i)));
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
                firstName = authorAttr.getNamedItem("firstname").getTextContent();
                lastName = authorAttr.getNamedItem("lastname").getTextContent();
            }

            public String toString() {
                return firstName + " " + lastName;
            }
        }

        public String toString() {
            String out = "name: " + name + "\ndescription: " + description;
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
