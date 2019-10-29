public class Player extends Creature {

    private Weapon weapon;
    private Armor armor;
    private Dice dice;

    public Player() {
        this(new Dice());
    }

    public Player(Dice dice) {
        super(10, 10);
        this.dice = dice;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @return int damage, the attack strength
     * <p>
     * Rolls number between 1-6 for every strength point and weapon damage if present.
     * Every rolled 6 gives the damage a +1 in attack.
     */
    @Override
    public int attack() {
        int rolls = getStrength();
        if (weapon != null) {
            rolls += weapon.getDamage();
        }
        return dice.roll(rolls, 6);
    }

    /**
     * @param damageAmount
     * @return String "You take [damage] damage!"
     * <p>
     * Rolls number between 1-6 for every armor point.
     * Every rolled 6 gives the player a damage reduction of 1.
     */
    @Override
    public String takeDamage(int damageAmount) {
        if (armor != null) {
            damageAmount -= dice.roll(armor.getArmorRating(), 6);
        }
        if (getStrength() <= damageAmount) {
            die();
            return "You take " + damageAmount + " damage and Die!";
        }
        setStrength(getStrength() - damageAmount);
        return "You take " + damageAmount + " damage!";
    }

    public Dice getDice() {
        return dice;
    }

    @Override
    public String toString() {
        return "Player{" +
                "speed=" + getSpeed() +
                ", strength=" + getStrength() +
                '}';
    }
}
