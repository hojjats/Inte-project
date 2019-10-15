public class Player {

    private int speed;
    private int health;
    final int MAX_HEALTH = 100;


    public Player(){
        speed = 10;
        health = MAX_HEALTH;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > MAX_HEALTH)
            throw new IllegalArgumentException("Health can't be less than zero (0)");
        this.health = health;
    }


    @Override
    public String toString() {
        return "Player{" +
                "speed=" + speed +
                ", health=" + health +
                '}';
    }
}
