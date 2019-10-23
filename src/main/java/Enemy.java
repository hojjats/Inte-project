public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;
    private Dice dice;

    public Enemy(String name,int strength,int speed, boolean isAggressive){
        this(name, strength, speed, isAggressive, new Dice());
    }

    public Enemy(String name,int strength,int speed, boolean isAggressive, Dice dice) {
        super(speed,strength);
        this.isAggressive = isAggressive;
        this.name = name;
        this.dice = dice;
    }

    public Enemy(){
        this("Grunt", 2,5, false);
    }

    public int attack(){
        return dice.roll(getStrength(), 6);
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
