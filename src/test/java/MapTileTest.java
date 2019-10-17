import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTileTest {

    @Test
    void createMapTile(){
        Effect e = new Effect();
        Position pos = new Position(0,0);
        MapTile mapTile = new MapTile(e, pos);
        assertEquals(mapTile.getEffect(),e);
        assertEquals(mapTile.getPosition(),pos);
    }



}
