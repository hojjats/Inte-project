import java.util.Scanner;

public class BattleModule {

    private Player player;
    private Enemy enemy;
    private boolean playerTurn, battleIsOver = false, gameIsOver = false;
    private Scanner scan;

    public BattleModule(Player player, Enemy enemy) {
        this(player, enemy, new Scanner(System.in));
    }

    public BattleModule(Player player, Enemy enemy, Scanner scan) {
        if (player == null || enemy == null || scan == null)
            throw new IllegalArgumentException("Player, Enemy and Scanner must be defined");
        this.player = player;
        this.enemy = enemy;
        this.scan = scan;
        setBattleInitiative(player.getSpeed() - enemy.getSpeed());
    }

    /* Checks creatures speed to determine who starts attacking
    if creatures have the same speed, both enemy and player rolls and the one with the highest roll
    starts the battle*/
    private void setBattleInitiative(int initiative) {
        if (initiative == 0) {
            playerTurn = roll() > 0;
        } else {
            playerTurn = initiative > 0;
        }
    }

    private int roll() {
        int winner;
        do {
            winner = player.getDice().rollDice() - enemy.getDice().rollDice();
        } while (winner == 0);
        return winner;
    }

    private void switchAttacker() {
        playerTurn = !playerTurn;
    }

    private boolean executeBattleCommand(int command) {
        switch (command) {
            case 1:
                System.out.println(playerAttack(player.attack()));
                return true;
            case 2:
                System.out.println(flee());
                return true;
            default:
                System.out.println("Invalid command");
                return false;
        }
    }


    public void startBattle() {
        if (!playerTurn) {
            System.out.println(enemyAttack(enemy.attack()));
        }
        if (!battleIsOver && !gameIsOver) {
            do {
                int command = scan.nextInt();
                boolean validCommand = executeBattleCommand(command);
                if (validCommand && !battleIsOver) {
                    System.out.println(enemyAttack(enemy.attack()));
                }
            } while (!battleIsOver && !gameIsOver);
        }
    }

    protected String flee() {
        String fleeMessage = "You attempt to flee";
        if (playerTurn) {
            battleIsOver = roll() > 0;
            switchAttacker();
        } else {
            return "Enemy Turn!";
        }
        fleeMessage = battleIsOver ? fleeMessage + " and succeed!" : fleeMessage + " but fail!";
        return fleeMessage;
    }

    public boolean isBattleOver() {
        return battleIsOver;
    }

    public boolean isGameOver() {
        return gameIsOver;
    }

    protected String playerAttack(int damage) {
        String attackMessage = "Enemy Turn!";
        if (playerTurn && enemy.isAlive()) {
            attackMessage = enemy.takeDamage(damage);
            if (!enemy.isAlive()) {
                battleIsOver = true;
            }
            switchAttacker();
        }
        return attackMessage;
    }


    protected String enemyAttack(int damage) {
        String attackMessage = "Player Turn!";
        if (!playerTurn && player.isAlive()) {
            attackMessage = player.takeDamage(damage);
            if (!player.isAlive()) {
                gameIsOver = true;
            }
            switchAttacker();
        }
        return attackMessage;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }
}
