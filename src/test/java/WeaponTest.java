import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WeaponTest {

    Weapon weapon = new Weapon("Firesword", 10);

    @Test
    void constructor() {
    }

    @Test
    void getName() {
        assertEquals(weapon.getName(), "Firesword");
    }

    @Test
    void getDurability() {
        assertEquals(weapon.getDurability(), 100);
    }

    @Test
    void setDurability() {
        int newDurability = 90;
        weapon.setDurability(newDurability);
        assertEquals(weapon.getDurability(), newDurability);
    }

    @Test
    void getDamage() {
        assertEquals(weapon.getDamage(), 10);
    }

}
