public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;
    private boolean isAlive;


    public Enemy(String name,int strength,int speed, boolean isAggressive){
        super(speed, strength);
        this.isAggressive = isAggressive;
        this.name = name;
        isAlive=true;
    }

    public int attack(){
        return getStrength();
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
