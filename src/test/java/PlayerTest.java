import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player p = new Player();

    @Test
    void constructorCall() {
        assertEquals(p.getHealth(), 100);
        assertEquals(p.getSpeed(), 10);
    }

    @Test
    void getHealth(){
        assertEquals(p.getHealth(),100);
    }

    @Test
    void getSpeed(){
        assertEquals(p.getSpeed(),10);

    }

    @Test
    void setHealthToPositiveValue(){
        int newVal = 90;
        p.setHealth(newVal);
       assertEquals(p.getHealth(),newVal);
    }

    @Test
    void setHealthToNegativeValue(){
        int newVal = -10;
        assertThrows(IllegalArgumentException.class, () -> {
        p.setHealth(newVal);
        });
    }

    @Test
    void setHealthToOverMaxHealth(){
        int newVal = 101;
        assertThrows(IllegalArgumentException.class, () -> {
            p.setHealth(newVal);
        });
    }

    @Test
    void setSpeedToPositiveValue(){
        int newVal = 5;
        p.setSpeed(newVal);
        assertEquals(p.getSpeed(),newVal);
    }











}
