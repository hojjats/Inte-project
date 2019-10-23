import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BattleModuleTest {
    private Player basicPlayer = new Player();
    private Enemy basicEnemy = new Enemy();
    private BattleModule battle = new BattleModule(basicPlayer,basicEnemy);
    private final Dice ALWAYS6_DIE = new Dice(new mocks.Random(6));
    private final Dice ALWAYS1_DIE = new Dice(new mocks.Random(1));

    private Player loadedPlayer = new Player(ALWAYS6_DIE);
    private Player failingPlayer = new Player(ALWAYS1_DIE);

    private Enemy loadedEnemy = new Enemy(ALWAYS6_DIE);
    private Enemy failingEnemy = new Enemy(ALWAYS1_DIE);



    @Test
    void startBattlePlayerInitiative(){
        assertTrue(battle.isPlayerTurn());
    }

    @Test
    void startBattleEnemyInitiative(){
        Enemy fastEnemy = new Enemy();
        fastEnemy.setSpeed(11);
        BattleModule battle = new BattleModule(basicPlayer,fastEnemy);
        assertFalse(battle.isPlayerTurn());

    }

    @Test
    void startBattleSameSpeedPlayerWins(){
        Enemy fastFailingEnemy = new Enemy(ALWAYS1_DIE);
        fastFailingEnemy.setSpeed(10);
        BattleModule playerInitiative = new BattleModule(loadedPlayer,fastFailingEnemy);
        assertTrue(playerInitiative.isPlayerTurn());
    }

    @Test
    void startBattleSameSpeedEnemyWins(){
        Enemy fastLoadedEnemy = new Enemy(ALWAYS6_DIE);
        fastLoadedEnemy.setSpeed(10);
        BattleModule enemyInitiative = new BattleModule(failingPlayer,fastLoadedEnemy);
        assertFalse(enemyInitiative.isPlayerTurn());
    }

    @Test
    void switchAttacker() {
        assertTrue(battle.isPlayerTurn());
        battle.playerAttack(1);
        assertFalse(battle.isPlayerTurn());
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
    }

    @Test
    void enemyAttacksOnPlayerTurn(){
        assertEquals("Player Turn!", battle.enemyAttack(1));
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

    @Test
    void fourAttacksEnemyWin(){
        battle.playerAttack(1);
        battle.enemyAttack(1);
        battle.playerAttack(0);
        assertEquals("You Died!",battle.enemyAttack(10));
        assertTrue(battle.isGameOver());
    }

    @Test
    void fleeSuccess(){
        BattleModule fleeSuccess = new BattleModule(loadedPlayer,failingEnemy);
        assertEquals(fleeSuccess.isBattleOver(),true);
    }

    @Test
    void fleeFailure(){
        BattleModule fleeFailure = new BattleModule(failingPlayer,loadedEnemy);
        assertEquals(fleeFailure.isBattleOver(),false);

    }

    @Test
    void attackStream(){
        BattleModule streamBattle = new BattleModule(loadedPlayer,basicEnemy,"1");
        assertEquals(1,basicEnemy.getStrength());
    }

    @Test
    void attackStreamUntilEnemyDead(){
        BattleModule streamBattle = new BattleModule(loadedPlayer,basicEnemy,"1 1");
        assertEquals(streamBattle.isBattleOver(),true);
        assertEquals(0,basicEnemy.getStrength());
    }

    @Test
    void attackStreamOneAttackThenFlee(){

    }


}
