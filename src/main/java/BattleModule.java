import java.util.Scanner;

public class BattleModule {

    private Player player;
    private Enemy enemy;
    private boolean battleIsOver = false;
    private boolean gameIsOver = false;
    private boolean playerTurn;
    private Scanner scan;

    public BattleModule(Player player,Enemy enemy){
        this.player = player;
        this.enemy = enemy;
        setBattleInitiative(player.getSpeed()-enemy.getSpeed());
        scan = new Scanner(System.in);
    }

    public BattleModule(Player player,Enemy enemy,String input){
        this.player = player;
        this.enemy = enemy;
        setBattleInitiative(player.getSpeed()-enemy.getSpeed());
        scan = new Scanner(input);
    }



    /* Checks creatures speed to determine who starts attacking
    if creatures have the same speed, the attacker is randomized*/
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


    public void battleCommand(int command){

        switch (command){
            case 1:
                playerAttack(player.attack());
                break;
            case 2:
                flee();
                break;
        }
    }


    public void startBattle(){
        while(!battleIsOver && !gameIsOver){
    /* TO-DO Should lock player and enemy in loop until one dies or player
    manages to flee
     */
        }
    }

    protected void flee(){
        battleIsOver = roll() > 0;
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
