import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player p = new Player();
    Weapon woodAxe = new Weapon("Wood Axe", 4);
    Armor leatherArmor = new Armor("Leather Armor", 6);


    @Test
    void constructorCall() {
        assertEquals(p.getStrength(), 10);
        assertEquals(p.getSpeed(), 10);
    }

    @Test
    void getSpeed(){
        assertEquals(p.getSpeed(),10);
    }

    @Test
    void setSpeedToPositiveValue(){
        int newVal = 5;
        p.setSpeed(newVal);
        assertEquals(p.getSpeed(),newVal);
    }

    @Test
    void getStrength(){
        assertEquals(p.getStrength(), 10);
    }

    @Test
    void setStrengthToNegativeValue(){
        int newVal = -10;
        assertThrows(IllegalArgumentException.class, () -> {
            p.setStrength(newVal);
        });
    }

    @Test
    void setStrengthToOverMaxStrength(){
        int newVal = 11;
        assertThrows(IllegalArgumentException.class, () -> {
            p.setStrength(newVal);
        });
    }

    @Test
    void setStrength(){
        p.setStrength(7);
        assertEquals(p.getStrength(), 7);
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
        assertEquals("Player{speed=10, strength=10}", p.toString());
    }

    @Test
    void attackWithoutWeapon(){
        Player player = new Player(new mocks.Random());
        int attackStrength = player.attack();
        System.out.println("Result: " + attackStrength);
        assertEquals(10, attackStrength);
    }

    @Test
    void attackWithWeapon() {
        Player player = new Player(new mocks.Random());
        player.setWeapon(woodAxe);
        int attackStrength = player.attack();
        assertEquals(14, attackStrength);
    }

    @Test
    void takeDamageWithoutArmor(){
        String str = p.takeDamage(1);
        assertEquals(p.getStrength(), 9);
        assertEquals(str, "You take 1 damage!");
    }

    @Test
    void takeDamageWithArmor(){
        Player player = new Player(new mocks.Random());
        // Armor rating 6
        player.setArmor(leatherArmor);
        String str = player.takeDamage(7);
        int playerStrength = player.getStrength();
        assertEquals(9, playerStrength);
        assertEquals(str, "You take "+(10-playerStrength)+" damage!");
    }

}
