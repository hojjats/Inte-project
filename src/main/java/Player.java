import javafx.geometry.Pos;

public class Player {

    private int speed;
    private int health;
    final int MAX_HEALTH = 100;
    private Position position;

    public Player(){
        speed = 10;
        health = MAX_HEALTH;
       position = new Position(0,0);
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }


    public Position moveNorth(){
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
    }



    @Override
    public String toString() {
        return "Player{" +
                "speed=" + speed +
                ", health=" + health +
                '}';
    }


}
