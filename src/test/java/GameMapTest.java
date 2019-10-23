import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class GameMapTest {
    GameMap basicMap = new GameMap(6);


    @Test
    void getMaptiles(){
        GameMap temp = new GameMap(4);
        MapTile[][] tempTiles = new MapTile[4][4];
        assertEquals(tempTiles.length,temp.getMapTiles()[0].length);
        assertEquals(tempTiles[0].length,temp.getMapTiles()[0].length);
    }

    @Test
    void validateCornerPositions(){
        Position validPosition1 = new Position(1,1);
        Position validPosition2 = new Position(6,6);
        Position validPosition3 = new Position(1,6);
        Position validPosition4 = new Position(6,1);

        assertTrue(basicMap.validatePosition(validPosition1));
        assertTrue(basicMap.validatePosition(validPosition2));
        assertTrue(basicMap.validatePosition(validPosition3));
        assertTrue(basicMap.validatePosition(validPosition4));
    }

    @Test
    void validateInvalidXorYPosition(){
        Position invalidPosition1 = new Position(0,3);
        Position invalidPosition2 = new Position(3,0);

        assertFalse(basicMap.validatePosition(invalidPosition1));
        assertFalse(basicMap.validatePosition(invalidPosition2));
    }

    @Test
    void validateMiddlePosition(){
        Position validPosition = new Position(3,3);

        assertTrue(basicMap.validatePosition(validPosition));
    }

    @Test
    void getDimensions() {
        assertEquals(6, basicMap.getDimensions());
    }




}
