import java.util.Random;

public class BattleModule {

    private Creature attacker;
    private Creature defender;
    private Player player;
    private Enemy enemy;
    private int playerInitiativeScore;
    private int enemyInitiativeScore;

    public BattleModule(Player player,Enemy enemy){
        this.player = player;
        this.enemy = enemy;
        setBattleInitiative(player.getSpeed()-enemy.getSpeed());
    }

    /* Checks creatures speed to determine who starts attacking
    if creatures have the same speed, the attacker is randomized*/
    private void setBattleInitiative(int initiative){
        if(initiative>0){
            this.attacker = player;
            this.defender = enemy;
        }
        else if(initiative<0){
            this.attacker = enemy;
            this.defender = player;
        }else{
            randomizeInitiative();
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



}
