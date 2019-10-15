import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameMapTest {

    @Test
    public void getMaptiles(){
        GameMap temp = new GameMap(4);
        MapTiles[][] tempTiles = new MapTiles[4][4];
        assertEquals(tempTiles.length,temp.getMapTiles()[0].length);
        assertEquals(tempTiles[0].length,temp.getMapTiles()[0].length);
    }




}
