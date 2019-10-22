import java.util.Random;

public class BattleModule {

    private Creature attacker;
    private Creature defender;
    private Player player;
    private Enemy enemy;
    private int playerInitiativeScore;
    private int enemyInitiativeScore;
    private boolean battleIsOver = false;
    private boolean gameIsOver = false;

    public BattleModule(Player player,Enemy enemy){
        this.player = player;
        this.enemy = enemy;
        this.attacker = player;
        this.defender = enemy;
        setBattleInitiative(player.getSpeed()-enemy.getSpeed());
    }

    /* Checks creatures speed to determine who starts attacking
    if creatures have the same speed, the attacker is randomized*/
    private void setBattleInitiative(int initiative){
        if(initiative==0){
            randomizeInitiative();
        }
        else if(initiative<0){
          switchAttacker();
        }

    }

    private void randomizeInitiative(){
        int initiative;
        Random rnd = new Random();
        do {
            initiative = rnd.nextInt(20)-10;
        }while (initiative == 0);

        if(initiative > 0) {
            attacker = player;
            defender = enemy;
            playerInitiativeScore = 1;
            enemyInitiativeScore = 0;
        }else{
            attacker = enemy;
            defender = player;
            playerInitiativeScore = 0;
            enemyInitiativeScore = 1;
        }
    }

    public Creature getAttacker(){
        return attacker;
    }

    public Creature getDefender(){
        return defender;
    }

    public Creature highestInitiative(){
        return playerInitiativeScore>enemyInitiativeScore ? player:enemy;
    }

    private void switchAttacker(){
       Creature temp = null;
       temp = attacker;
       attacker = defender;
       defender = temp;
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
        // TO-DO implement flee mechanic based on speed
    }

    public boolean isBattleOver() {
        return battleIsOver;
    }

    public boolean isGameOver(){
        return gameIsOver;
    }

    protected String playerAttack(int damage){
        String attackMessage="Enemy Turn!";
        if(attacker == player) {
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
        if(attacker == enemy) {
            if (player.isAlive()) {
             attackMessage = player.takeDamage(damage);
                 if (!player.isAlive()) {
                      gameIsOver = true;
                      battleIsOver = true;
                 }
                 switchAttacker();
            }
        }
        return attackMessage;
    }

}
