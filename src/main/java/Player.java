public class Player {

    private int speed;
    private int health;
    final int MAX_HEALTH = 100;
    private int x;
    private int y;

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Player{" +
                "speed=" + speed +
                ", health=" + health +
                '}';
    }
}
