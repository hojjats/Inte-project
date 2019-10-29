import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class GameMapTest {

    GameMap gameMap = new GameMap();
    MapTile startTile = new MapTile(new Effect(), "startTile");


    @Test
    void createGameMap() {
        assertEquals(gameMap.getTile(new Position(0, 0)), startTile);
    }

    @Test
    void getDirectionNorth() {
        assertEquals(Directions.NORTH, gameMap.getDirection(startTile, new Position(0, 1)));
    }

    @Test
    void getDirectionSouth() {
        assertEquals(Directions.SOUTH, gameMap.getDirection(startTile, new Position(0, -1)));
    }

    @Test
    void getDirectionWest() {
        assertEquals(Directions.WEST, gameMap.getDirection(startTile, new Position(-1, 0)));
    }

    @Test
    void getDirectionEast() {
        assertEquals(Directions.EAST, gameMap.getDirection(startTile, new Position(1, 0)));
    }

    @Test
    void moveToExistingTileDiscoveredTiles() {
        MapTile newTile = gameMap.move(startTile, new Position(0, 1));
        int discoveredTilesBeforeMoveBack = gameMap.getDiscoveredTiles();
        gameMap.move(newTile, new Position(0, 0));
        int discoveredTilesAfterMoveBack = gameMap.getDiscoveredTiles();
        assertEquals(discoveredTilesBeforeMoveBack, discoveredTilesAfterMoveBack);
    }

    @Test
    void moveBackAndForth() {
        MapTile newTile = gameMap.move(startTile, new Position(0, 1));
        assertEquals(startTile.getDiscoveredTiles(), gameMap.move(newTile, new Position(0, 0)).getDiscoveredTiles());
    }


    @Test
    void moveIncrementsDiscoveredTiles() {
        int discoveredTilesBeforeMove = gameMap.getDiscoveredTiles();
        gameMap.move(gameMap.getStartTile(), new Position(0, 1));
        int discoveredTilesAfterMove = gameMap.getDiscoveredTiles();
        assertEquals(discoveredTilesBeforeMove + 1, discoveredTilesAfterMove);
    }

    @Test
    void moveToNonExistingTile() {
        int beforeMove = gameMap.getDiscoveredTiles();
        assertEquals(gameMap.move(gameMap.getStartTile(), new Position(0, 1)), new MapTile(new Effect(), "tile:" + 1, gameMap.getStartTile(), gameMap.getDirection(gameMap.getStartTile(), new Position(0, 1)), gameMap.getDiscoveredTiles()));
        assertEquals(beforeMove + 1, gameMap.getDiscoveredTiles());
    }

    /*GameMap basicMap = new GameMap(6);

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

*/

    /*
    @Test
    void moveToExisting(){
        GameMap gm = new GameMap();
        assertEquals(gm.move(new Position(0,0)), gm.getTile(new Position(0,0)));
    }


    @Test
    void moveToExistingTile() {
        GameMap gameMap = new GameMap();
        int tilesBeforeMove = gameMap.getDiscoveredTiles();
        gameMap.move(new Position(0, 0));
        int tilesAfterMove = gameMap.getDiscoveredTiles();
        assertEquals(tilesBeforeMove, tilesAfterMove);
    }*/

}
