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

    @Test
    void moveNorth(){
        Position temp = new Position(0,-1);
        assertEquals(p.moveNorth().getY(),temp.getY());

    }

    @Test
    void moveSouth(){
        Position temp = new Position(0,1);
        assertEquals(p.moveSouth().getY(),temp.getY());

    }

    @Test
    void moveWest(){
        Position temp = new Position(-1,0);
        assertEquals(p.moveWest().getX(),temp.getX());

    }

    @Test
    void moveEast(){
        Position temp = new Position(1,0);
        assertEquals(p.moveEast().getX(),temp.getX());

    }










}
