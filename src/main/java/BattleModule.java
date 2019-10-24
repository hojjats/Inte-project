import java.util.Scanner;

public class BattleModule {

    private Player player;
    private Enemy enemy;
    private boolean battleIsOver = false;
    private boolean gameIsOver = false;
    private boolean playerTurn;
    private Scanner scan;

    public BattleModule(Player player,Enemy enemy){
        this(player,enemy,new Scanner(System.in));
    }

    public BattleModule(Player player,Enemy enemy,Scanner scan){
        this.player = player;
        this.enemy = enemy;
        setBattleInitiative(player.getSpeed()-enemy.getSpeed());
        this.scan = scan;
    }



    /* Checks creatures speed to determine who starts attacking
    if creatures have the same speed, both enemy and player rolls and the one with the highest roll
    starts the battle*/
    private void setBattleInitiative(int initiative){
        if(initiative==0){
           playerTurn = roll() > 0;
        }
        else {
            playerTurn = initiative > 0;
        }
    }

    private int roll(){
        int winner;
        do {
            winner = player.getDice().rollDice()-enemy.getDice().rollDice();
        }while (winner == 0);
        return winner;
    }

    private void switchAttacker(){
        playerTurn = !playerTurn;
    }


    private void battleCommand(int command){

        switch (command){
            case 1:
                System.out.println(playerAttack(player.attack()));
                break;
            case 2:
                System.out.println(flee());
                break;
        }
    }


    public void startBattle(){

        do{
            int command = scan.nextInt();
            battleCommand(command);
            if(!battleIsOver){
                System.out.println(enemyAttack(enemy.attack()));
            }
        }while(!battleIsOver && !gameIsOver);
    }

    protected String flee(){
        String fleeMessage = "You attempt to flee";
        if(playerTurn){
            battleIsOver = roll() > 0;
            switchAttacker();
        }else {
            return "Enemy Turn!";
        }
        fleeMessage = battleIsOver ? fleeMessage+" and succeed!":fleeMessage+" but fail!";
        return fleeMessage;
    }

    public boolean isBattleOver() {
        return battleIsOver;
    }

    public boolean isGameOver(){
        return gameIsOver;
    }

    protected String playerAttack(int damage){
        String attackMessage="Enemy Turn!";
        if(battleIsOver || gameIsOver){
            return "Battle has ended";
        }
        if(playerTurn) {
            if (enemy.isAlive()) {
                attackMessage = enemy.takeDamage(damage);
                if (!enemy.isAlive()) {
                    battleIsOver = true;
                }
                switchAttacker();
            }
        }
        return attackMessage;
    }

    protected String enemyAttack(int damage){
        String attackMessage = "Player Turn!";
        if(battleIsOver || gameIsOver){
            return "Battle has ended";
        }
        if(!playerTurn) {
            if (player.isAlive()) {
             attackMessage = player.takeDamage(damage);
                 if (!player.isAlive()) {
                      gameIsOver = true;
                 }
                 switchAttacker();
            }
        }
        return attackMessage;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }
}
