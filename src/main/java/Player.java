public class Player extends Creature {

    public Player(){
        super(10,10,10);
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
    public String takeDamage(int damageAmount) {
        setCurrentHealth(getCurrentHealth() - damageAmount);
        return "You take "+damageAmount+" damage!";
    }
}
