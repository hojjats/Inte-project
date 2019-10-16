import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Game game = new Game(6);
    Player player = game.getPlayer();


    @Test
    void playerMoveNorth(){
        Position expected = new Position(1,0);
        player.setPosition(new Position(1,1));
        game.movePlayer(Directions.NORTH);
        assertEquals(expected,player.getPosition());
    }




}
