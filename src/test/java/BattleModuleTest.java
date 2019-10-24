import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(basicEnemy.getName()+" takes 1 damage", battle.playerAttack(1));
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
        assertEquals(basicEnemy.getName()+" takes 2 damage and Dies!",battle.playerAttack(2));
        assertTrue(battle.isBattleOver());
        assertFalse(battle.isGameOver());
    }

    @Test
    void playerDies(){
        battle.playerAttack(1);
        assertEquals("You take 10 damage and Die!", battle.enemyAttack(10));
        assertTrue(battle.isGameOver());
    }

    @Test
    void threeAttacksPlayerWin(){
        battle.playerAttack(1);
        battle.enemyAttack(1);
        assertEquals(basicEnemy.getName()+" takes 1 damage and Dies!",battle.playerAttack(1));
        assertTrue(battle.isBattleOver());
        assertEquals(9, basicPlayer.getStrength());
    }

    @Test
    void fourAttacksEnemyWin(){
        battle.playerAttack(1);
        battle.enemyAttack(1);
        battle.playerAttack(0);
        assertEquals("You take 10 damage and Die!",battle.enemyAttack(10));
        assertTrue(battle.isGameOver());
    }

    @Test
    void fleeSuccess(){
        BattleModule fleeSuccess = new BattleModule(loadedPlayer,failingEnemy);
        fleeSuccess.flee();
        assertTrue(fleeSuccess.isBattleOver());
    }

    @Test
    void fleeFailure(){
        BattleModule fleeFailure = new BattleModule(failingPlayer,loadedEnemy);
        fleeFailure.flee();
        assertFalse(fleeFailure.isBattleOver());
    }

    @Test
    void fleeOnEnemyTurn(){
        battle.playerAttack(1);
        assertEquals("Enemy Turn!",battle.flee());
        assertFalse(battle.isPlayerTurn());
    }

    @Test
    void attackThenFleeStream(){
        BattleModule streamBattle = new BattleModule(loadedPlayer,failingEnemy,"1 2");
        loadedPlayer.setStrength(1);
        streamBattle.startBattle();
        assertEquals(1,failingEnemy.getStrength());
        assertTrue(streamBattle.isBattleOver());
    }

    @Test
    void attackStreamUntilEnemyDead(){
        BattleModule streamBattle = new BattleModule(loadedPlayer,failingEnemy,"1 1");
        loadedPlayer.setStrength(1);
        streamBattle.startBattle();
        assertTrue(streamBattle.isBattleOver());
        assertFalse(failingEnemy.isAlive());
    }

    @Test
    void playerStartAndGetsKilled(){
        BattleModule streamBattle = new BattleModule(failingPlayer,loadedEnemy,"1 2");
        failingPlayer.setStrength(4);
        streamBattle.startBattle();
        assertTrue(streamBattle.isGameOver());
        assertFalse(failingPlayer.isAlive());
    }

    @Test
    void fleeUntilKilled(){
        BattleModule streamBattle = new BattleModule(failingPlayer,loadedEnemy,"2 2 2 2 2");
        streamBattle.startBattle();
        assertTrue(streamBattle.isGameOver());
        assertFalse(failingPlayer.isAlive());
    }


}
