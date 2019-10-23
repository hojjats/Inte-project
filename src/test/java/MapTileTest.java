import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTileTest {

    MapTile startTile = new MapTile(new Effect(), "StartWood");


    @Test
    void create5tiles(){
        MapTile[] tiles = new MapTile[10];
        tiles[0] = startTile;
        for (int i = 1; i < 5 ; i++) {
            tiles[i] = new MapTile(new Effect(),"tile:"+i, tiles[i-1], Directions.NORTH, i+1 );
        }
        assertEquals(tiles[1].getDiscoveredTiles(),2);
        assertEquals(tiles[4].getDiscoveredTiles(),5);
    }


    @Test
    void createStartTile() {
        Effect e = new Effect();
        String name = "StartTile";
        MapTile mapTile = new MapTile(e, "StartTile");
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), 0);
        assertEquals(mapTile.getPosition().getY(), 0);
        assertEquals(mapTile.getName(), name);
        assertEquals(mapTile.getDiscoveredTiles(),1);
    }

    @Test
    void createMapTileToEastOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.EAST,1);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX() + 1);
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY());
    }

    @Test
    void createMapTileToNorthOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.NORTH,1);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX());
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY() + 1);
    }

    @Test
    void createMapTileToWestOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.WEST,1);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX() - 1);
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY());
    }

    @Test
    void createMapTileToSouthOfStarterTile() {
        Effect e = new Effect();
        MapTile mapTile = new MapTile(e, "HeroStorm", startTile, Directions.SOUTH,1);
        assertEquals(mapTile.getEffect(), e);
        assertEquals(mapTile.getPosition().getX(), startTile.getPosition().getX());
        assertEquals(mapTile.getPosition().getY(), startTile.getPosition().getY() - 1);
    }

    @Test
    void createMapTileWithNullPreviousTile() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), "HeroStorm", null, Directions.SOUTH,1);
        });
    }

    @Test
    void createMapTileWithNullDirection() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), "HeroStorm", startTile, null,1);
        });
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
    void createMapTileZeroDiscoveredTiles(){
        assertThrows(IllegalArgumentException.class, () -> {
            new MapTile(new Effect(), "HeroStorm",startTile,Directions.NORTH,0);
        });

    }

    @Test
    void setTileNorth() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.NORTH,1);
        assertEquals(mapTile.getSouthTile(), startTile);
        assertEquals(startTile.getNorthTile(), mapTile);
    }

    @Test
    void setTileSouth() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.SOUTH,1);
        assertEquals(mapTile.getNorthTile(), startTile);
        assertEquals(startTile.getSouthTile(), mapTile);
    }

    @Test
    void setTileEast() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.EAST,1);
        assertEquals(mapTile.getWestTile(), startTile);
        assertEquals(startTile.getEastTile(), mapTile);
    }

    @Test
    void setTileWest() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        assertEquals(mapTile.getEastTile(), startTile);
        assertEquals(startTile.getWestTile(), mapTile);
    }

    @Test
    void getDiscoveredTiles() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        assertEquals(mapTile.getDiscoveredTiles(), 1);
        MapTile mapTile2 = new MapTile(new Effect(), "HeroStorm", mapTile, Directions.WEST,3);
        assertEquals(mapTile2.getDiscoveredTiles(), 3);
    }

    @Test
    void setEnemyTier1() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        mapTile.setDiscoveredTiles(3);
        mapTile.setEnemyOnTile();
        assertEquals(mapTile.getEnemyOnTile().getStrength(), 1);
    }

    @Test
    void setEnemeyTier2() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        mapTile.setDiscoveredTiles(5);
        mapTile.setEnemyOnTile();
        assertEquals(mapTile.getEnemyOnTile().getStrength(), 2);
    }

    @Test
    void setEnemyTier3() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        mapTile.setDiscoveredTiles(10);
        mapTile.setEnemyOnTile();
        assertEquals(mapTile.getEnemyOnTile().getStrength(), 3);
    }

    @Test
    void setItemOnTileEvenTile() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        mapTile.setDiscoveredTiles(3);
        mapTile.setItemOnTile();
        assertTrue(mapTile.getItemOnTile() instanceof Weapon);
    }

    @Test
    void setItemOnTileUnevenTile() {
        MapTile mapTile = new MapTile(new Effect(), "HeroStorm", startTile, Directions.WEST,1);
        mapTile.setDiscoveredTiles(6);
        mapTile.setItemOnTile();
        assertTrue(mapTile.getItemOnTile() instanceof Armor);
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
