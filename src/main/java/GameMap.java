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

    public MapTile move(MapTile currentTile, Position newPos) {
        if (tiles.get(newPos) != null)
            return tiles.get(newPos);


        return null;
    }

    public int getDiscoveredTiles() {
        return tiles.size();
    }

    public Directions getDirection(MapTile currentTile, Position newPosition){
        if (currentTile.getPosition().x == newPosition.getX() && currentTile.getPosition().getY() +1 == newPosition.getY())
            return Directions.NORTH;
        if (currentTile.getPosition().x == newPosition.getX() && currentTile.getPosition().getY() -1 == newPosition.getY())
            return Directions.SOUTH;
        if (currentTile.getPosition().x -1 == newPosition.getX() && currentTile.getPosition().getY() == newPosition.getY())
            return Directions.WEST;
        if (currentTile.getPosition().x +1 == newPosition.getX() && currentTile.getPosition().getY() == newPosition.getY())
            return Directions.EAST;
        return null;
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
