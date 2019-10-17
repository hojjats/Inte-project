import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player p = new Player();

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
        assertEquals(p.getStrength(), 6);
    }


    @Test
    void setStrength(){
        p.setStrength(7);
        assertEquals(p.getStrength(), 7);
    }


    @Test
    void attack(){
          int attackStrength = p.attack();
          assertEquals(attackStrength, 6);
    }

    @Test
    void takeDamage(){
        p.takeDamage(10);
        assertEquals(p.getCurrentHealth(), 90);
    }



}
