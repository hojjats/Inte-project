import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PositionTest {

    Position p = new Position(1, 1);

    @Test
    void getX() {
        assertEquals(p.getX(), 1);
    }

    @Test
    void getY() {
        assertEquals(p.getY(), 1);
    }

    @Test
    void setXPositive() {
        p.setX(2);
        assertEquals(p.getX(), 2);
    }

    @Test
    void setYPositive() {
        p.setY(2);
        assertEquals(p.getY(), 2);
    }

    @Test
    void setXNegative() {
        p.setX(-2);
        assertEquals(p.getX(), -2);
    }

    @Test
    void setYNegative() {
        p.setY(-2);
        assertEquals(p.getY(), -2);
    }

    @Test
    void equals() {
        Position pos1 = new Position(3, 3);
        Position pos2 = new Position(3, 3);
        assertEquals(pos1, pos2);
    }

    @Test
    void equalsNotPosition() {
        Position pos1 = new Position(3, 3);
        Object obj = new Object();
        assertNotEquals(pos1, obj);
    }

}
