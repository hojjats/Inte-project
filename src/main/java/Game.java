public class Game {

    private GameMap gameMap;
    private Player player;
    private MapTile currentMapTile;

    public Game() {
        gameMap = new GameMap();
        currentMapTile = gameMap.getStartTile();
        player = new Player();
    }

    /** public void movePlayer(Directions direction){
     Position tempPos = null;
     switch(direction){
     case NORTH:
     tempPos = player.moveNorth();
     break;
     case SOUTH:
     tempPos = player.moveSouth();
     break;
     case WEST:
     tempPos = player.moveWest();
     break;
     case EAST:
     tempPos = player.moveEast();
     break;
     }

     if(validatePosition(tempPos)){
     player.setPosition(tempPos);
     }
     }**/



   /* public Player getPlayer(){
        return player;
    }

    private boolean validatePosition(Position pos) {
        return gameMap.validatePosition(pos);*/
    //}

}
