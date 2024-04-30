import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = new Document();

            doc.addCharacter('H', "Arial", 12, "Red");
            doc.addCharacter('e', "Calibri", 14, "Blue");
            doc.addCharacter('l', "Verdana", 16, "Black");
            doc.addCharacter('l', "Calibri", 16, "Yellow");
            doc.addCharacter('o', "Times New Roman", 12, "Green");
            doc.addCharacter('w', "Verdana", 14, "Green");
            doc.addCharacter('o', "Arial", 12, "Black");
            doc.addCharacter('r', "Calibri", 12, "Yellow");
            doc.addCharacter('l', "Times New Roman", 14, "Red");
            doc.addCharacter('d', "Arial", 16, "Blue");

            //save content
            doc.saveToFile("HelloWorldCS4800.txt");

            //load content
            Document newDoc = new Document();
            newDoc.loadFromFile("HelloWorldCS4800.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}