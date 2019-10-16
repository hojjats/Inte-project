import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeaponTest {
    Weapon weapon = new Weapon("Wood Axe", 3);

    @Test
    void getName() {
        assertEquals(weapon.getName(), "Wood Axe");
    }

    @Test
    void getDamage() {
        assertEquals(weapon.getDamage(), 3);
    }



}
