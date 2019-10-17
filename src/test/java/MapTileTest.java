import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTileTest {

    MapTile startTile = new MapTile(new Effect(), "StartWood");


    @Test
    void createStartTile() {
        Effect e = new Effect();
        String name = "StartTile";
        MapTile mapTile = new MapTile(e, "StartTile");
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), 0);
        assertEquals(mapTile.getPosition().getY(), 0);
        assertEquals(mapTile.getName(), name);

    }

    @Test
    void createMapTileToEastOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.EAST);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX() + 1);
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY());
    }

    @Test
    void createMapTileToNorthOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.NORTH);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX());
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY() + 1);

    }

    @Test
    void createMapTileToWestOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.WEST);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX() - 1);
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY());
    }

    @Test
    void createMapTileToSouthOfStarterTile(){
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.SOUTH);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX());
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY() - 1);
    }


    @Test
    void createMapTileNullEffect() {
        MapTile mapTile = new MapTile(null, "HeroStorm");
        assertNull(mapTile.getEffect());
    }



    @Test
    void createMapTileNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), null);
        });
    }

    @Test
    void createMapTileEmptyStringName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), "");
        });
    }

    @Test
    void createMapTileWhitespacesName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), "   ");
        });
    }

    @Test
    void getEffect() {
        Effect e = new Effect();
        MapTile maptile = new MapTile(e, "HeroStorm");
        assertEquals(maptile.getEffect(), e);
    }

    @Test
    void getEffectNull() {
        MapTile maptile = new MapTile(null, "HeroStorm");
        assertNull(maptile.getEffect());
    }

    @Test
    void getName() {
        MapTile maptile = new MapTile(new Effect(), "HeroStorm");
        assertEquals(maptile.getName(), "HeroStorm");
    }

    @Test
    void setTile() {

    }


}
