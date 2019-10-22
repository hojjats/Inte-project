public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;



    public Enemy(String name,int strength,int speed, boolean isAggressive){
        super(speed, strength);
        this.isAggressive = isAggressive;
        this.name = name;
    }

    public Enemy(){
        super(5,2);
        isAggressive=false;
        name="Grunt";
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


    public String takeDamage(int damageAmount){
        if(!isAlive()){
            return name+" is already dead!";
        }
        if(getStrength()<= damageAmount){
            die();
            return name +" Dies!";
        }
        setStrength(getStrength()-damageAmount);
        return name +" takes "+ damageAmount+" damage!";
    }

    @Override
    public String toString() {
        return "Enemy{" +
            "isAggressive=" + isAggressive +
            ", name='" + name + '\'' +
            '}';
    }
}
