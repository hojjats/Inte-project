
public abstract class Creature {

    private int speed;
    private int currentHealth;
    private int maxHealth;
    private int strength;

    public Creature(int strength, int speed, int maxHealth) {
        if(strength<=0||maxHealth<=0||speed<0){
            throw new IllegalArgumentException();
        }
        this.speed = speed;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.strength = strength;
    }


   /** public Position moveNorth(){
        Position tempPos = getPosition();
        tempPos.setY(tempPos.getY() - 1);

        return tempPos;
    }

    public Position moveSouth(){
        Position tempPos = getPosition();
        tempPos.setY(tempPos.getY() + 1);
        return tempPos;
    }

    public Position moveWest(){
        Position tempPos = getPosition();
        tempPos.setX(tempPos.getX() - 1);
        return tempPos;
    }

    public Position moveEast() {
        Position tempPos = getPosition();
        tempPos.setX(tempPos.getX() + 1);
        return tempPos;
    }**/


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0 || currentHealth > maxHealth)
            throw new IllegalArgumentException("Health can't be less than zero (0)");
        this.currentHealth = currentHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public abstract int attack();

    public abstract String takeDamage(int damageAmount);

}
