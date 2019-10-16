import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {


    @Test
    void equals(){
        Position pos1 = new Position(3,3);
        Position pos2 = new Position(3,3);
        //assertTrue(pos1.equals(pos2));
        assertEquals(pos1,pos2);
    }

}
