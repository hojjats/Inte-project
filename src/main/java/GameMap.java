public class GameMap {

    private MapTiles[][] mapTiles;
    private int dimensions;

    public GameMap(int dimensions){
        this.dimensions=dimensions;
        mapTiles = new MapTiles[dimensions][dimensions];
        // to lay out tiles
        randomizeMap();
    }

    //Method that takes creates tiles and places them on the MapTiles Matrix
    private void randomizeMap(){
    // do something
    }

    public MapTiles[][] getMapTiles() {
        return mapTiles;
    }

    public int getDimensions() {
        return dimensions;
    }

    public boolean validatePosition(Position pos){
        int tempX = pos.getX();
        int tempY = pos.getY();
        return (tempX < dimensions && tempX > 0 && tempY < dimensions && tempY > 0);
    }
}
