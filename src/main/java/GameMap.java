import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private Map<Position, MapTile> tiles = new HashMap<>();

    public GameMap() {
        tiles.put(new Position(0, 0), new MapTile(new Effect(), "startTile"));

    }

    public MapTile getTile(Position pos) {
        return tiles.get(pos);
    }

    public MapTile getStartTile() {
        return tiles.get(new Position(0, 0));
    }

    public MapTile move(MapTile currentTile, Position newPos) {
        if (tiles.get(newPos) != null)
            return tiles.get(newPos);
        MapTile newTile = new MapTile(new Effect(), "tile:" + tiles.size(), currentTile, getDirection(currentTile, newPos), getDiscoveredTiles());
        tiles.put(newPos, newTile);
        return newTile;
    }

    public int getDiscoveredTiles() {
        return tiles.size() + 1;
    }

    public Directions getDirection(MapTile currentTile, Position newPosition) {
        int diffX = currentTile.getPosition().getX() - newPosition.getX();
        int diffY = currentTile.getPosition().getY() - newPosition.getY();
        Directions direction;
        if (diffX == 0) {
            direction = diffY > 0 ? Directions.SOUTH : Directions.NORTH;
        } else {
            direction = diffX > 0 ? Directions.WEST : Directions.EAST;
        }
        return direction;
    }



/*
    private MapTile[][] mapTiles;
    private int dimensions;

    public GameMap(int dimensions) {
        this.dimensions = dimensions;
        mapTiles = new MapTile[dimensions][dimensions];
        // to lay out tiles
        randomizeMap();
    }

    //Method that creates tiles and places them on the MapTile Matrix
    private void randomizeMap() {
        // do something
    }

    public MapTile[][] getMapTiles() {
        return mapTiles;
    }

    public int getDimensions() {
        return dimensions;
    }

    public boolean validatePosition(Position pos) {
        int tempX = pos.getX();
        int tempY = pos.getY();
        return (tempX <= dimensions && tempX > 0 && tempY <= dimensions && tempY > 0);
    }*/


}
