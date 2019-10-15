public class GameMap {

    private MapTiles[][] mapTiles;
    private int dimensions;
   // private Player player;

    public GameMap(int dimensions){
        this.dimensions=dimensions;
        mapTiles = new MapTiles[dimensions][dimensions];
        //player = new Player();
        // to lay out tiles
        randomizeMap();
    }


    //Method that takes creates tiles and places them on the MapTiles Matrix
    private void randomizeMap(){
    // do something
    }


    //Takes the direction the player wants to move and checks if it is possible, if it is
    //The player will be moved there, else they will get a message saying it is not possible
    private void move(Directions direction){
        int tempX = player.getXcoordinate();
        int tempY = player.getYcoordinate();
        switch(direction){
            case EAST:
                tempX++;
                break;
            case WEST:
                tempX--;
                break;
            case SOUTH:
                tempY++;
                break;
            case NORTH:
                tempY--;
                break;
        }
      

    }

    public MapTiles[][] getMapTiles() {
        return mapTiles;
    }
}
