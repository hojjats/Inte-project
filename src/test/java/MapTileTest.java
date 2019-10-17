import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTileTest {

    @Test
    void createMapTile() {
        Effect e = new Effect();
        Position pos = new Position(0, 0);
        MapTile mapTile = new MapTile(e, pos,"HeroStorm");
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition(), pos);
    }

    @Test
    void createMapTileNullEffect() {
        Position pos = new Position(0, 0);
        MapTile mapTile = new MapTile(null, pos,"HeroStorm");
        assertNull(mapTile.getEffect());
    }

    @Test
    void createMapTileNullPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), null, "HeroStorm");
        });
    }
    @Test
    void createMapTileNullName(){
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), new Position(0,0), null);
        });
    }

    @Test
    void createMapTileEmptyStringName(){
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), new Position(0,0), "");
        });
    }

    @Test
    void getEffect() {
        Effect e = new Effect();
        MapTile maptile = new MapTile(e, new Position(0, 0), "HeroStorm");
        assertEquals(maptile.getEffect(), e);
    }

    @Test
    void getEffectNull(){
        MapTile maptile = new MapTile(null, new Position(0, 0), "HeroStorm");
        assertNull(maptile.getEffect());
    }

    @Test
    void getName() {
        MapTile maptile = new MapTile(new Effect(), new Position(0, 0), "HeroStorm");
        assertEquals(maptile.getName(), "HeroStorm");
    }

}
