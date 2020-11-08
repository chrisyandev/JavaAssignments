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

/**
 * BookStoreFactory. Extracts DOM objects from an XML file,
 * gets the attributes and text content, creates appropriate
 * classes to store the data, uses the classes to create DOM
 * objects which get outputted into a new XML file.
 *
 * @author Chris Yan
 * @version 1.0
 */
public final class BookStoreFactory {

    /** Holds the single instance of BookStoreFactory. */
    private static BookStoreFactory instance = null;

    /* Prevents creating more than one instance */
    private BookStoreFactory() { }

    /**
     * Gets the single instance of BookStoreFactory.
     * @return single instance of BookStoreFactory
     */
    public static BookStoreFactory getInstance() {
        if (instance == null) {
            instance = new BookStoreFactory();
        }
        return instance;
    }

    /**
     * Drives the program.
     *
      * @param args unused
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void main(final String[] args) throws IOException,
            SAXException, ParserConfigurationException, TransformerException {
        BookStoreFactory bsf = BookStoreFactory.getInstance();
        bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
    }

    /* Parses the XML file into a Document object */
    private Document getDOM(final String fileName)
            throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    /* Constructs a DOM representation of a book in memory */
    private Node createBook(final Book bookIn, final Document doc)
            throws ParserConfigurationException {
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
        // It is possible for a subcategory to not exist
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

    /*
    Creates the same book nodes in the original XML file and adds them
    to a bookstore node which is added to a Document
    */
    private Document assembleBookstore(final String inputFile)
            throws ParserConfigurationException, IOException, SAXException {
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

    /* Outputs the Document to a new XML file */
    private void outputBookstore(final Document doc, final String outputFile)
            throws TransformerException {
        TransformerFactory transformerFactory =
                TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFile));

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        transformer.transform(source, result);
    }

    /**
     * Calls methods to clone the XML file.
     *
     * @param inputFile the input file name
     * @param outputFile the output file name
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public void duplicateBookstore(final String inputFile,
                                   final String outputFile)
            throws IOException, SAXException, ParserConfigurationException,
            TransformerException {
        Document doc = assembleBookstore(inputFile);
        outputBookstore(doc, outputFile);
    }

    /*
    To hold the node and related nodes' text
    content and/or attributes
    */
    private class Book {

        /** Holds a book Element. */
        private final Element bookElement;

        /** Holds the book's ISBN. */
        private final String isbn;

        /** Holds the book's year. */
        private final String year;

        /** Holds the book's edition. */
        private final String edition;

        /** Holds the book's name. */
        private final String name;

        /** Holds the book's description. */
        private final String description;

        /** Holds the courses the book is for. */
        private final ArrayList<Course> courses;

        /** Holds the book's authors. */
        private final ArrayList<Author> authors;

        /** Holds the book's publisher. */
        private final String publisher;

        /** Holds the book's price in different currencies. */
        private final ArrayList<Price> prices;

        /** Holds data relating to the book's stock. */
        private final Stock stock;

        /*
        Extracts child nodes of a book node and gets their
        text content and/or attributes
        */
        Book(final Node bookItem) {
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

        /*
        To hold the node and related nodes' text
        content and/or attributes
        */
        private class Stock {

            /** Holds category the book is in. */
            private String category;

            /** Holds subcategory the book is in. */
            private String subcategory;

            /** Holds number of copies in stock. */
            private int copiesInStock;

            /** Holds the URL of the book's cover image. */
            private String coverImageURL;

            /** Holds the number of days the book is available for. */
            private int availabilityDays;

            /* Extracts data from nodes */
            Stock() {
                Node stockItem =
                        bookElement.getElementsByTagName("stock").item(0);
                NodeList children = stockItem.getChildNodes();
                // If the node name matches what we are looking for,
                // gets the content and/or attributes
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
                            default:
                                // Nothing needs to be done
                        }
                    }
                }
            }
        }

        /*
        To hold the node and related nodes' text
        content and/or attributes
        */
        private class Course {

            /** Holds the course name. */
            private String name;

            /** Holds the institute the course is taught at. */
            private String institute;

            /* Extracts data from nodes */
            Course(final Node courseItem) {
                name = courseItem.getTextContent();
                NamedNodeMap courseAttr = courseItem.getAttributes();
                institute = courseAttr
                        .getNamedItem("institute").getTextContent();
            }
        }

        /*
        To hold the node and related nodes' text
        content and/or attributes
        */
        private class Author {

            /** Holds the author's first name. */
            private final String firstName;

            /** Holds the author's last name. */
            private final String lastName;

            /* Extracts data from nodes */
            Author(final Node authorItem) {
                NamedNodeMap authorAttr = authorItem.getAttributes();
                firstName =
                        authorAttr.getNamedItem("firstname").getTextContent();
                lastName =
                        authorAttr.getNamedItem("lastname").getTextContent();
            }
        }

        /*
        To hold the node and related nodes' text
        content and/or attributes
        */
        private class Price {

            /** Holds the price currency. */
            private String currency;

            /** Holds the price value. */
            private float value;

            /* Extracts data from nodes */
            Price(final Node priceItem) {
                NamedNodeMap priceAttr = priceItem.getAttributes();
                currency = priceAttr.getNamedItem("currency").getTextContent();
                value = Float.parseFloat(priceItem.getTextContent());
            }
        }
    }
}
