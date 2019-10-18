import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleModuleTest {

    Player basicPlayer = new Player();
    Enemy basicEnemy = new Enemy("Grunt",2,2,4,false);

    @Test
    void startBattle(){
        BattleModule battle = new BattleModule(basicPlayer,basicEnemy);

        assertEquals(battle.getAttacker(),basicPlayer);
        assertEquals(battle.getDefender(),basicEnemy);
    }
}
