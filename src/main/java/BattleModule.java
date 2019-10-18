public class BattleModule {

    private Creature attacker;
    private Creature defender;

    public BattleModule(Player player,Enemy enemy){
        int initiative = player.getSpeed()-enemy.getSpeed();

        if(initiative>0){
            this.attacker = player;
            this.defender = enemy;
        }
    }

    public Creature getAttacker(){
        return attacker;
    }

    public Creature getDefender(){
        return defender;
    }
}
