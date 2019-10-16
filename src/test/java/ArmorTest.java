import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArmorTest {
    Armor armor = new Armor("Leather Armor", 2);

    @Test
    void getName() {
        assertEquals(armor.getName(), "Leather Armor");
    }

    @Test
    void getArmorRating() {
        assertEquals(armor.getArmorRating(), 2);
    }

}
