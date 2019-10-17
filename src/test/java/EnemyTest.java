import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest{

    Enemy basicEnemy = new Enemy("Goblin", 20,2,2,true);



    @Test
    void createEnemy(){
        Enemy enemy = new Enemy("Troll",100, 10,10,true);

        assertEquals(enemy.getCurrentHealth(),100);
        assertEquals(enemy.getStrength(),10);
        assertEquals(enemy.getSpeed(),10);
        assertEquals(enemy.isAggressive(),true);
        assertEquals(enemy.getName(),"Troll");
    }

    @Test
    void createEnemyInvalidStrength(){
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,-1,10,false);
        });

        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,0,10,false);
        });

    }

    @Test
    void createEnemyInvalidHealth(){
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",-1,10,10,false);
        });
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",0,10,10,false);
        });
    }

    @Test
    void createEnemyInvalidSpeed(){
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,10,-1,false);
        });
    }

    @Test
    void attack(){
        assertEquals(basicEnemy.attack(),2);
    }

    @Test
    void takeDamage(){
        assertEquals(basicEnemy.getName()+" takes "+10+" damage",basicEnemy.takeDamage(10));
        assertEquals(basicEnemy.getCurrentHealth(),10);
    }

    @Test
    void enemyKilled(){
        assertEquals(basicEnemy.getName()+" dies",basicEnemy.takeDamage(23));
        assertFalse(basicEnemy.isAlive());
    }

    @Test
    void dealDamageOnKilled(){
        basicEnemy.takeDamage(20);
        assertEquals(basicEnemy.getName()+" is already dead",basicEnemy.takeDamage(1));
    }

}
