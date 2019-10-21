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
        fastEnemy.setSpeed(11);
        BattleModule battle = new BattleModule(basicPlayer,fastEnemy);

        assertEquals(battle.getAttacker(),fastEnemy);
        assertEquals(battle.getDefender(),basicPlayer);
    }

    @Test
    void startBattleSameInitiative(){
        Enemy equalEnemy = new Enemy();
        equalEnemy.setSpeed(10);
        BattleModule battle = new BattleModule(basicPlayer,equalEnemy);
        assertEquals(battle.highestInitiative(),battle.getAttacker());
    }



}
