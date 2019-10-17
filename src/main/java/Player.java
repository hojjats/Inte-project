public class Player extends Creature {

    public Player(){
        super(0,0,6, 10, 100);
    }

    @Override
    public String toString() {
        return "Player{" +
                "speed=" + getSpeed() +
                ", health=" + getCurrentHealth() +
                '}';
    }

    @Override
    public int attack() {
        return getStrength();
    }

    @Override
    public void takeDamage(int damageAmount) {
        setCurrentHealth(getCurrentHealth() - damageAmount);
    }
}
