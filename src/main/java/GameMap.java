public class GameMap {

    private MapTile[][] mapTiles;
    private int dimensions;

    public GameMap(int dimensions){
        this.dimensions=dimensions;
        mapTiles = new MapTile[dimensions][dimensions];
        // to lay out tiles
        randomizeMap();
    }

    //Method that creates tiles and places them on the MapTile Matrix
    private void randomizeMap(){
    // do something
    }

    public MapTile[][] getMapTiles() {
        return mapTiles;
    }

    public int getDimensions() {
        return dimensions;
    }

    public boolean validatePosition(Position pos){
        int tempX = pos.getX();
        int tempY = pos.getY();
        return (tempX <= dimensions && tempX > 0 && tempY <= dimensions && tempY > 0);
    }
}
