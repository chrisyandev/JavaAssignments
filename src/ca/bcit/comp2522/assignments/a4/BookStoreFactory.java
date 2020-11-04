package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BookStoreFactory {

    private static BookStoreFactory instance = null;

    private BookStoreFactory() { }

    public static BookStoreFactory getInstance() {
        if (instance == null) {
            instance = new BookStoreFactory();
        }
        return instance;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        BookStoreFactory bsf = BookStoreFactory.getInstance();
        bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
    }

    private Document getDOM(String fileName) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private Node createBook(Book bookIn, Document doc) throws ParserConfigurationException {
        Element bookEl = doc.createElement("book");

        bookEl.setAttribute("isbn", bookIn.isbn);
        bookEl.setAttribute("year", bookIn.year);
        bookEl.setAttribute("edition", bookIn.edition);

        Element nameEl = doc.createElement("name");
        nameEl.setTextContent(bookIn.name);
        bookEl.appendChild(nameEl);

        Element descEl = doc.createElement("description");
        descEl.setTextContent(bookIn.description);
        bookEl.appendChild(descEl);

        Element courseAppEl = doc.createElement("courseapplicability");
        for (Book.Course c : bookIn.courses) {
            Element courseEl = doc.createElement("course");
            courseEl.setAttribute("institute", c.institute);
            courseEl.setTextContent(c.name);
            courseAppEl.appendChild(courseEl);
        }
        bookEl.appendChild(courseAppEl);

        for (Book.Author a : bookIn.authors) {
            Element authorEl = doc.createElement("author");
            authorEl.setAttribute("firstname", a.firstName);
            authorEl.setAttribute("lastname", a.lastName);
            bookEl.appendChild(authorEl);
        }

        Element publishEl = doc.createElement("publisher");
        publishEl.setTextContent(bookIn.publisher);
        bookEl.appendChild(publishEl);

        for (Book.Price p : bookIn.prices) {
            Element priceEl = doc.createElement("price");
            priceEl.setAttribute("currency", p.currency);
            priceEl.setTextContent(String.format("%.2f", p.value));
            bookEl.appendChild(priceEl);
        }

        Element stockEl = doc.createElement("stock");
        Element categoryEl = doc.createElement("category");
        Element copiesEl = doc.createElement("copiesinstock");
        Element coverEl = doc.createElement("coverimage");
        Element availEl = doc.createElement("availability");
        categoryEl.setTextContent(bookIn.stock.category);
        copiesEl.setTextContent(String.valueOf(bookIn.stock.copiesInStock));
        coverEl.setAttribute("url", bookIn.stock.coverImageURL);
        availEl.setAttribute(
                "days", String.valueOf(bookIn.stock.availabilityDays));

        stockEl.appendChild(categoryEl);
        if (bookIn.stock.subcategory != null) {
            Element subcategoryEl = doc.createElement("subcategory");
            subcategoryEl.setTextContent(bookIn.stock.subcategory);
            stockEl.appendChild(subcategoryEl);
        }
        stockEl.appendChild(copiesEl);
        stockEl.appendChild(coverEl);
        stockEl.appendChild(availEl);
        bookEl.appendChild(stockEl);

        return bookEl;
    }

    private Document assembleBookstore(String inputFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("bookstore");
        doc.appendChild(root);

        NodeList bookList = getDOM(inputFile).getElementsByTagName("book");
        for (int i = 0; i < bookList.getLength(); i++) {
            Node bookItem = createBook(new Book(bookList.item(i)), doc);
            root.appendChild(bookItem);
        }
        return doc;
    }

    private void outputBookstore(Document doc, String outputFile) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFile));

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        transformer.transform(source, result);
    }

    public void duplicateBookstore(String inputFile, String outputFile) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document doc = assembleBookstore(inputFile);
        outputBookstore(doc, outputFile);
    }

    private class Book {

        private final Element bookElement;
        private final String isbn;
        private final String year;
        private final String edition;
        private final String name;
        private final String description;
        private final ArrayList<Course> courses;
        private final ArrayList<Author> authors;
        private final String publisher;
        private final ArrayList<Price> prices;
        private final Stock stock;

        Book(Node bookItem) {
            courses = new ArrayList<>();
            authors = new ArrayList<>();
            prices = new ArrayList<>();
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

            NodeList priceList = bookElement.getElementsByTagName("price");
            for (int i = 0; i < priceList.getLength(); i++) {
                prices.add(new Price(priceList.item(i)));
            }

            stock = new Stock();
        }

        private class Stock {
            private String category;
            private String subcategory;
            private int copiesInStock;
            private String coverImageURL;
            private int availabilityDays;

            Stock() {
                Node stockItem = bookElement.getElementsByTagName("stock").item(0);
                NodeList children = stockItem.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    Node n = children.item(i);
                    if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element child = (Element) n;
                        switch (child.getNodeName()) {
                            case "category":
                                category = child.getTextContent();
                                break;
                            case "subcategory":
                                subcategory = child.getTextContent();
                                break;
                            case "copiesinstock":
                                copiesInStock = Integer.parseInt(
                                        child.getTextContent());
                                break;
                            case "coverimage":
                                coverImageURL = child.getAttribute("url");
                                break;
                            case "availability":
                                availabilityDays = Integer.parseInt(
                                        child.getAttribute("days"));
                                break;
                        }
                    }
                }
            }
        }

        private class Course {
            private String name;
            private String institute;

            Course(Node courseItem) {
                name = courseItem.getTextContent();
                NamedNodeMap courseAttr = courseItem.getAttributes();
                institute = courseAttr.getNamedItem("institute").getTextContent();
            }
        }

        private class Author {
            private final String firstName;
            private final String lastName;

            Author(Node authorItem) {
                NamedNodeMap authorAttr = authorItem.getAttributes();
                firstName =
                        authorAttr.getNamedItem("firstname").getTextContent();
                lastName =
                        authorAttr.getNamedItem("lastname").getTextContent();
            }
        }

        private class Price {
            private String currency;
            private float value;

            Price(Node priceItem) {
                NamedNodeMap priceAttr = priceItem.getAttributes();
                currency = priceAttr.getNamedItem("currency").getTextContent();
                value = Float.parseFloat(priceItem.getTextContent());
            }
        }
    }
}
