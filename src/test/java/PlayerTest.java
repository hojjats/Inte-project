import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player p = new Player();
    Weapon woodAxe = new Weapon("Wood Axe", 4);
    Armor leatherArmor = new Armor("Leather Armor", 6);


    @Test
    void constructorCall() {
        assertEquals(p.getCurrentHealth(), 100);
        assertEquals(p.getSpeed(), 10);
    }

    @Test
    void getHealth(){
        assertEquals(p.getCurrentHealth(),100);
    }

    @Test
    void getSpeed(){
        assertEquals(p.getSpeed(),10);
    }

    @Test
    void setHealthToPositiveValue(){
        int newVal = 90;
        p.setCurrentHealth(newVal);
       assertEquals(p.getCurrentHealth(),newVal);
    }

    @Test
    void setHealthToNegativeValue(){
        int newVal = -10;
        assertThrows(IllegalArgumentException.class, () -> {
        p.setCurrentHealth(newVal);
        });
    }

    @Test
    void setHealthToOverMaxHealth(){
        int newVal = 101;
        assertThrows(IllegalArgumentException.class, () -> {
            p.setCurrentHealth(newVal);
        });
    }

    @Test
    void setSpeedToPositiveValue(){
        int newVal = 5;
        p.setSpeed(newVal);
        assertEquals(p.getSpeed(),newVal);
    }

    @Test
    void moveNorth(){

    }

    @Test
    void moveSouth(){

    }

    @Test
    void moveWest(){

    }

    @Test
    void moveEast(){


    }

    @Test
    void getStrength(){
        assertEquals(p.getStrength(), 10);
    }


    @Test
    void setStrength(){
        p.setStrength(7);
        assertEquals(p.getStrength(), 7);
    }

    @Test
    void setArmor() {
        p.setArmor(leatherArmor);
        assertEquals(p.getArmor(),  leatherArmor);
    }

    @Test
    void setWeapon() {
        p.setWeapon(woodAxe);
        assertEquals(p.getWeapon(), woodAxe);
    }

    @Test
    void toStringMethod() {
        assertEquals("Player{speed=10, health=100}", p.toString());
    }

    @Test
    void attackWithoutWeapon(){
        int attackStrength = p.attack();
        assertEquals(attackStrength, 10);
    }

    @Test
    void attackWithWeapon() {
        p.setWeapon(woodAxe);
        int attackStrength = p.attack();
        assertEquals(attackStrength, (10+4));
    }

    @Test
    void takeDamageWithoutArmor(){
        String str = p.takeDamage(10);
        assertEquals(p.getCurrentHealth(), 90);
        assertEquals(str, "You take 10 damage!");
    }

    @Test
    void takeDamageWithArmor(){
        p.setArmor(leatherArmor);
        String str = p.takeDamage(10);
        assertEquals(p.getCurrentHealth(), 96);
        assertEquals(str, "You take 4 damage!");
    }

}
