import java.util.*;

// factory to manage character property instances
class CharacterPropertyFactory {
    private static final Map<List<Object>, CharacterProperty> propertiesMap = new HashMap<>();

    public static CharacterProperty getProperty(String font, int size, String color) {
        List<Object> key = Arrays.asList(font, size, color);
        propertiesMap.putIfAbsent(key, new CharacterProperty(font, size, color));
        return propertiesMap.get(key);
    }
}