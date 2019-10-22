import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(battle.getDefender(),basicPlayer);
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
        battle.playerTestAttack(1);
        assertEquals(battle.getAttacker(), basicEnemy);
        battle.enemyTestAttack(1);
        assertEquals(battle.getAttacker(), basicPlayer);
    }

    @Test
    void damageDealing(){
        Enemy basicEnemy = new Enemy();
        BattleModule battle = new BattleModule(basicPlayer, basicEnemy);
        assertEquals("Grunt takes 1 damage", battle.playerTestAttack(1));
        assertEquals("You take 1 damage!",battle.enemyTestAttack(1));
    }

    @Test
    void playerAttacksOnEnemyTurn(){
    battle.playerTestAttack(1);
    assertEquals("Enemy Turn!",battle.playerTestAttack(1));
    assertEquals(battle.getAttacker(),basicEnemy);
    }

    @Test
    void enemyAttacksOnPlayerTurn(){
        assertEquals("Player Turn!", battle.enemyTestAttack(1));
        assertEquals(battle.getAttacker(),basicPlayer);
    }

    @Test
    void enemyDies(){
        assertEquals(basicEnemy.getName()+" Dies!",battle.playerTestAttack(2));
        assertTrue(battle.isBattleOver());
        assertFalse(battle.isGameOver());
    }

    @Test
    void playerDies(){
        battle.playerTestAttack(1);
        assertEquals("You Died!", battle.enemyTestAttack(10));
        assertTrue(battle.isBattleOver());
        assertTrue(battle.isGameOver());
    }

    @Test
    void threeAttacksPlayerWin(){
        battle.playerTestAttack(1);
        battle.enemyTestAttack(1);
        assertEquals(basicEnemy.getName()+" Dies!",battle.playerTestAttack(1));
        assertTrue(battle.isBattleOver());
        assertEquals(9, basicPlayer.getStrength());
    }


}
