import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleModuleTest {
    Player basicPlayer = new Player();



    @Test
    void startBattlePlayerInitiative(){
        Enemy basicEnemy = new Enemy();
        BattleModule battle = new BattleModule(basicPlayer,basicEnemy);

        assertEquals(battle.getAttacker(),basicPlayer);
        assertEquals(battle.getDefender(),basicEnemy);
    }

    @Test
    void startBattleEnemyInitiative(){
        Enemy fastEnemy = new Enemy();
        BattleModule battle = new BattleModule(basicPlayer,fastEnemy);

    }

}
