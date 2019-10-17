public class Enemy {

    private boolean isAggressive;
    private String name;


    public Enemy(String name,int health,int strength,int speed, boolean isAggressive){
        super(health,strength,speed);
        this.isAggressive = isAggressive;
        this.name = name;
    }

    public int attack(){
        return strength;
    }

    public void takeDamage(int damage){

    }



}
