import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    Enemy basicEnemy = new Enemy("Goblin", 5, 2, true);

    @Test
    void createEnemyEkv() {
        Enemy enemy = new Enemy("testEnemy", 10, 5, true);
        assertEquals(enemy.getName(), "testEnemy");
        assertEquals(enemy.getStrength(), 10);
        assertEquals(enemy.getSpeed(), 5);
        assertTrue(enemy.isAggressive());
    }

    @Test
    void createEnemyEmptyNameEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("", 10, 5, true);
        });
    }

    @Test
    void createEnemyNullNameEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy(null, 10, 5, true);
        });
    }

    @Test
    void createEnemyWhitespaceOnlyNameEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("    ", 10, 5, true);
        });
    }

    @Test
    void createEnemyNameTooLongEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("hehehehehehehehehehehehehe", 10, 5, true);
        });
    }

    @Test
    void createEnemyStrengthLessThanOneEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("testEnemy", -2, 5, true);
        });
    }

    @Test
    void createEnemyStrengthMoreThanTwentyEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("testEnemy", 21, 5, true);
        });
    }

    @Test
    void createEnemyNegativeSpeedEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("testEnemy", 10, -1, true);
        });
    }

    @Test
    void createEnemySpeedToHighEkv() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("testEnemy", 10, 21, true);
        });
    }

    @Test
    void takeDamageNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            basicEnemy.takeDamage(-1);
        });
    }

    @Test
    void createEnemy() {
        Enemy enemy = new Enemy("Troll", 10, 10, true);

        assertEquals(enemy.getStrength(), 10);
        assertEquals(enemy.getSpeed(), 10);
        assertEquals(enemy.isAggressive(), true);
        assertEquals(enemy.getName(), "Troll");
    }

    @Test
    void createEnemyInvalidStrength() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("Troll", -1, 5, false);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("Troll", 0, 5, false);
        });

    }

    @Test
    void createEnemyInvalidSpeed() {
        assertThrows(IllegalArgumentException.class, () -> {
            Enemy enemy = new Enemy("Troll", 10, -1, false);
        });
    }

    @Test
    void attack() {
        Enemy enemy = new Enemy("Lucky", 5, 5, true, new Dice(new mocks.Random(6)));
        assertEquals(5, enemy.attack());
    }

    @Test
    void takeDamage() {
        assertEquals(basicEnemy.getName() + " takes " + 3 + " damage", basicEnemy.takeDamage(3));
        assertEquals(basicEnemy.getStrength(), 2);
    }

    @Test
    void enemyKilled() {
        assertEquals(basicEnemy.getName() + " takes 5 damage and Dies!", basicEnemy.takeDamage(5));
        assertFalse(basicEnemy.isAlive());
    }

}
