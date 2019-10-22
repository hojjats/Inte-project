import java.util.Random;

public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;
    private boolean isAlive;
    private Random Rnd = new Random();

    public Enemy(String name,int strength,int speed, boolean isAggressive){
        super(speed, strength);
        this.isAggressive = isAggressive;
        this.name = name;
        isAlive=true;
    }

    public Enemy(mocks.Random mockRandom) {
        super(5,5);
        this.Rnd = mockRandom;
        isAggressive = false;
        name = "Lucky Lucy";
    }

    public Enemy(){
        super(5,5);
        isAggressive=false;
        name="Grunt";
    }

    public int attack(){
        int damage = 0;
        for (int i = 0; i < getStrength(); i++) {
            int rndInt = Rnd.nextInt((6-1) +1) +1;
            if (rndInt == 6) {
                damage++;
            }
        }
        return damage;
    }

    public String getName(){
        return name;
    }

    public boolean isAggressive(){
        return isAggressive;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public String takeDamage(int damageAmount){
        if(!isAlive){
            return name+" is already dead";
        }
        if(getStrength()<= damageAmount){
            isAlive = false;
            return name +" dies";
        }
        setStrength(getStrength()-damageAmount);
        return name +" takes "+ damageAmount+" damage";
    }





}
