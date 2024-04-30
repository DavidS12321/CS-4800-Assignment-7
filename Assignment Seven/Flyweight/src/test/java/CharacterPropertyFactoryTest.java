import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertyFactoryTest {

    @Test
    public void testPropertySharing() {
        CharacterProperty property1 = CharacterPropertyFactory.getProperty("Arial", 12, "Red");
        CharacterProperty property2 = CharacterPropertyFactory.getProperty("Arial", 12, "Red");
        assertSame(property1, property2);
    }

    @Test
    public void testUniquePropertyCreation() {
        CharacterProperty property1 = CharacterPropertyFactory.getProperty("Arial", 12, "Red");
        CharacterProperty property2 = CharacterPropertyFactory.getProperty("Calibri", 14, "Blue");
        assertNotSame(property1, property2);
    }
}