import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTilesTest {
    private MapTile tile;

    @Test
    void forestTileConstructorCall(){
        tile = new ForestTile(false);
        assertEquals(tile.isBlocked(), false);
        assertEquals(tile.getActionPointsCost(), 1);
    }

    @Test
    void snowTileConstructorCall(){
        tile = new SnowTile(false);
        assertEquals(tile.isBlocked(),false);
        assertEquals(tile.getActionPointsCost(),2);
    }




}
