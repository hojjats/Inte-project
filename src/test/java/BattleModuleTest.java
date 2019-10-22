import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BattleModuleTest {
    private Player basicPlayer = new Player();
    private Enemy basicEnemy = new Enemy();
    private BattleModule battle = new BattleModule(basicPlayer,basicEnemy);

    @Test
    void startBattlePlayerInitiative(){
        assertEquals(battle.getAttacker(),basicPlayer);
        assertEquals(battle.getDefender(),basicEnemy);
    }

    @Test
    void startBattleEnemyInitiative(){
        Enemy fastEnemy = new Enemy();
        fastEnemy.setSpeed(11);
        BattleModule battle = new BattleModule(basicPlayer,fastEnemy);

        assertEquals(battle.getAttacker(),fastEnemy);
    }

    @Test
    void startBattleSameInitiative(){
        Enemy equalEnemy = new Enemy();
        equalEnemy.setSpeed(10);
        BattleModule battle = new BattleModule(basicPlayer,equalEnemy);
        assertEquals(battle.highestInitiative(),battle.getAttacker());
    }

    @Test
    void switchAttacker() {
        battle.playerAttack(1);
        assertEquals(battle.getAttacker(), basicEnemy);
        battle.enemyAttack(1);
        assertEquals(battle.getAttacker(), basicPlayer);
    }

    @Test
    void damageDealing(){
        Enemy basicEnemy = new Enemy();
        BattleModule battle = new BattleModule(basicPlayer, basicEnemy);
        assertEquals("Grunt takes 1 damage", battle.playerAttack(1));
        assertEquals("You take 1 damage!",battle.enemyAttack(1));
    }

    @Test
    void playerAttacksOnEnemyTurn(){
    battle.playerAttack(1);
    assertEquals("Enemy Turn!",battle.playerAttack(1));
    assertEquals(battle.getAttacker(),basicEnemy);
    }

    @Test
    void enemyAttacksOnPlayerTurn(){
        assertEquals("Player Turn!", battle.enemyAttack(1));
        assertEquals(battle.getAttacker(),basicPlayer);
    }

    @Test
    void enemyDies(){
        assertEquals(basicEnemy.getName()+" Dies!",battle.playerAttack(2));
        assertTrue(battle.isBattleOver());
        assertFalse(battle.isGameOver());
    }

    @Test
    void playerDies(){
        battle.playerAttack(1);
        assertEquals("You Died!", battle.enemyAttack(10));
        assertTrue(battle.isGameOver());
    }

    @Test
    void threeAttacksPlayerWin(){
        battle.playerAttack(1);
        battle.enemyAttack(1);
        assertEquals(basicEnemy.getName()+" Dies!",battle.playerAttack(1));
        assertTrue(battle.isBattleOver());
        assertEquals(9, basicPlayer.getStrength());
    }




}
