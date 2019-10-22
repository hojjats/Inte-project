import java.util.Random;

public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;
    private Random rnd;

    public Enemy(String name,int strength,int speed, boolean isAggressive){
        this(name, strength, speed, isAggressive, new Random());
    }

    public Enemy(String name,int strength,int speed, boolean isAggressive, Random rnd) {
        super(speed,strength);
        this.isAggressive = isAggressive;
        this.name = name;
        this.rnd = rnd;
    }

    public Enemy(){
        this("Grunt", 2,5, false);
    }

    public int attack(){
        int damage = 0;
        for (int i = 0; i < getStrength(); i++) {
            int rndInt = rnd.nextInt((6-1) +1) +1;
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

    public String takeDamage(int damageAmount){
        if(!isAlive()){
            return name+" is already dead";
        }
        if(getStrength()<= damageAmount){
            die();
            return name +" Dies!";
        }
        setStrength(getStrength()-damageAmount);
        return name +" takes "+ damageAmount+" damage";
    }





}
