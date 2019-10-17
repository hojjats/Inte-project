import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest{

    Enemy basicEnemy = new Enemy("Goblin", 20,2,2,true);



    @Test
    void createEnemy(){
        Enemy enemy = new Enemy("Troll",100, 10,10,true);

        assertEquals(enemy.getHealth(),100);
        assertEquals(enemy.getStrength(),10);
        assertEquals(enemy.getSpeed(),10);
        assertEquals(enemy.isAggressive(),true);
        assertEquals(enemy.getName(),"Troll");
    }

    @Test
    void createEnemyInvalidStrength(){
        assertThrows(InvalidArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,-1,10,false);
        });

        assertThrows(InvalidArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,0,10,false);
        });

    }

    @Test
    void createEnemyInvalidHealth(){
        assertThrows(InvalidArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",-1,10,10,false);
        });
        assertThrows(InvalidArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",0,10,10,false);
        });
    }

    @Test
    void createEnemyInvalidSpeed(){
        assertThrows(InvalidArgumentException.class,() -> {
            Enemy enemy = new Enemy("Troll",100,10,-1,false);
        });
    }

    @Test
    void enemyAttack(){
        assertEquals(basicEnemy.attack(),2);
    }


}
