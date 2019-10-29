
public abstract class Creature {

    private int speed;
    private int maxStrength;
    private int strength;
    private boolean isAlive;

    public Creature(int speed, int maxStrength) {
        if (maxStrength < 1 || maxStrength > 20)
            throw new IllegalArgumentException("Strength must be between 1 and 20");
        if (speed < 1 || speed > 20)
            throw new IllegalArgumentException("Speed must be between 1 and 20");
        this.speed = speed;
        this.strength = maxStrength;
        this.maxStrength = maxStrength;
        isAlive = true;
    }


    /**
     * public Position moveNorth(){
     * Position tempPos = getPosition();
     * tempPos.setY(tempPos.getY() - 1);
     * <p>
     * return tempPos;
     * }
     * <p>
     * public Position moveSouth(){
     * Position tempPos = getPosition();
     * tempPos.setY(tempPos.getY() + 1);
     * return tempPos;
     * }
     * <p>
     * public Position moveWest(){
     * Position tempPos = getPosition();
     * tempPos.setX(tempPos.getX() - 1);
     * return tempPos;
     * }
     * <p>
     * public Position moveEast() {
     * Position tempPos = getPosition();
     * tempPos.setX(tempPos.getX() + 1);
     * return tempPos;
     * }
     **/


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /*
    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0 || currentHealth > maxStrength)
            throw new IllegalArgumentException("Health can't be less than zero (0)");
        this.currentHealth = currentHealth;
    }
    */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0 || strength > maxStrength)
            throw new IllegalArgumentException("Health can't be less than zero (0)");
        this.strength = strength;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }

    public abstract int attack();

    public abstract String takeDamage(int damageAmount);

}
