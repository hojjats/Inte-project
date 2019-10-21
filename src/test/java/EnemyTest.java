import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EnemyTest{

    Enemy basicEnemy = new Enemy("Goblin", 5,2,true);

    @Test
    void createEnemy(){
        Enemy enemy = new Enemy("Troll",10, 10,true);

        assertEquals(enemy.getStrength(),10);
        assertEquals(enemy.getSpeed(),10);
        assertEquals(enemy.isAggressive(),true);
        assertEquals(enemy.getName(),"Troll");
    }

    @Test
    void createEnemyInvalidStrength(){
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",-1,5,false);
        });

        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",0,5,false);
        });

    }

    @Test
    void createEnemyInvalidSpeed(){
        assertThrows(IllegalArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",10,-1,false);
        });
    }

    @Test
    void attack(){
        assertEquals(basicEnemy.attack(),5);
    }

    @Test
    void takeDamage(){
        assertEquals(basicEnemy.getName()+" takes "+3+" damage",basicEnemy.takeDamage(3));
        assertEquals(basicEnemy.getStrength(),2);
    }

    @Test
    void enemyKilled(){
        assertEquals(basicEnemy.getName()+" dies",basicEnemy.takeDamage(5));
        assertFalse(basicEnemy.isAlive());
    }

    @Test
    void dealDamageOnKilled(){
        basicEnemy.takeDamage(5);
        assertEquals(basicEnemy.getName()+" is already dead",basicEnemy.takeDamage(1));
    }

}
