import java.io.*;
import java.util.*;

class Document {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, String font, int size, String color) {
        CharacterProperty property = CharacterPropertyFactory.getProperty(font, size, color);
        Character character = new Character(c, property);
        characters.add(character);
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character character : characters) {
                writer.write(character.getCharacter() + ":" +
                        character.getProperty().getFont() + "," +
                        character.getProperty().getSize() + "," +
                        character.getProperty().getColor() + System.lineSeparator());
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                char c = parts[0].charAt(0);
                String[] props = parts[1].split(",");
                addCharacter(c, props[0], Integer.parseInt(props[1]), props[2]);
            }
        }
    }
}