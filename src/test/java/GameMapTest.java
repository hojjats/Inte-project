import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameMapTest {
    GameMap basicMap = new GameMap(6);


    @Test
    public void getMaptiles(){
        GameMap temp = new GameMap(4);
        MapTile[][] tempTiles = new MapTile[4][4];
        assertEquals(tempTiles.length,temp.getMapTiles()[0].length);
        assertEquals(tempTiles[0].length,temp.getMapTiles()[0].length);
    }


}
