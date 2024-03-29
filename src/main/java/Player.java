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
        if (armor == null)
            throw new IllegalArgumentException("Armor can't be null");
        this.armor = armor;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setWeapon(Weapon weapon) {
        if (weapon == null)
            throw new IllegalArgumentException("Weapon can't be null");
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
        if (damageAmount < 0)
            throw new IllegalArgumentException("Damage can't be negative");
        if (armor != null) {
            damageAmount -= dice.roll(armor.getArmorRating(), 6);
        }
        if (getStrength() <= damageAmount) {
            die();
            return String.format("You take %d damage and Die!", damageAmount);
        }
        setStrength(getStrength() - damageAmount);
        return String.format("You take %d damage!", damageAmount);
    }

    public Dice getDice() {
        return dice;
    }

    @Override
    public String toString() {
        return String.format("Player{speed=%d, strength=%d}", getSpeed(), getStrength());
    }
}
