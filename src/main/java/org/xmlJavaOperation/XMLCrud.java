package org.xmlJavaOperation;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import java.io.File;

public class XMLCrud {
    static String FILE_PATH = "data.xml";

    public static void main(String[] args) {
        //createXML();        // C
        readXML();          // R
        updateEmail();      // U
        deleteAge();        // D
    }

    // CREATE
    public static void createXML() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("root");
            root.appendChild(root);

            Element person = doc.createElement("person");
            doc.appendChild(person);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("Varun"));
            person.appendChild(name);

            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode("30"));
            person.appendChild(age);

            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("john@example.com"));
            person.appendChild(email);

            saveXML(doc);
            System.out.println("✅ XML Created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void readXML() {
        try {
            Document doc = loadXML();
            doc.getDocumentElement().normalize();

            Node nameNode = doc.getElementsByTagName("name").item(0);
            Node ageNode = doc.getElementsByTagName("age").item(0);
            Node emailNode = doc.getElementsByTagName("email").item(0);

            if (nameNode != null)
                System.out.println("Name: " + nameNode.getTextContent());
            else
                System.out.println("Name tag not found.");

            if (ageNode != null)
                System.out.println("Age: " + ageNode.getTextContent());
            else
                System.out.println("Age tag not found.");

            if (emailNode != null)
                System.out.println("Email: " + emailNode.getTextContent());
            else
                System.out.println("Email tag not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateEmail() {
        try {
            Document doc = loadXML();

            Node emailNode = doc.getElementsByTagName("email").item(0);
            emailNode.setTextContent("newemail@example.com");

            saveXML(doc);
            System.out.println("✏️ Email Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteAge() {
        try {
            Document doc = loadXML();

            Node ageNode = doc.getElementsByTagName("age").item(0);
            if (ageNode != null) {
                ageNode.getParentNode().removeChild(ageNode);
                saveXML(doc);
                System.out.println("🗑️ Age Removed");
            } else {
                System.out.println("⚠️ Age tag not found. Nothing deleted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void removeWhitespaceNodes(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = childNodes.getLength() - 1; i >= 0; i--) {
            Node child = childNodes.item(i);
            if (child.getNodeType() == Node.TEXT_NODE && child.getTextContent().trim().isEmpty()) {
                node.removeChild(child);
            } else if (child.hasChildNodes()) {
                removeWhitespaceNodes(child);
            }
        }
    }

    // Utility: Load XML from file
    private static Document loadXML() throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringElementContentWhitespace(true); // 🔑 This helps
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }

    // Utility: Save XML to file
    private static void saveXML(Document doc) throws Exception {
        removeWhitespaceNodes(doc); // 💡 This line removes blank text nodes
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}