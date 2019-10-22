import java.util.Random;

public class Player extends Creature {

    private Weapon weapon;
    private Armor armor;
    private Random Rnd = new Random();

    public Player(){
        super(10,10);
    }

    public Player(mocks.Random mockRandom) {
        super(10, 10);
        this.Rnd = mockRandom;
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
     *
     * @return int damage, the attack strength
     *
     * Rolls number between 1-6 for every strength point and weapon damage if present.
     * Every rolled 6 gives the damage a +1 in attack.
     *
     */
    @Override
    public int attack() {
        int rolls = getStrength();
        if (weapon != null) {
            rolls += weapon.getDamage();
        }
        int damage = 0;
        for (int i = 0; i < rolls; i++) {
            int rndInt = Rnd.nextInt((6 - 1) + 1) + 1;
            if (rndInt == 6) {
                damage++;
            }
        }
        return damage;
    }

    /**
     *
     * @param damageAmount
     * @return String "You take [damage] damage!"
     *
     * Rolls number between 1-6 for every armor point.
     * Every rolled 6 gives the player a damage reduction of 1.
     *
     */
    @Override
    public String takeDamage(int damageAmount) {
        if (armor != null) {
            for (int i = 0; i < armor.getArmorRating(); i++) {
                int rndInt = Rnd.nextInt((6 - 1) + 1) + 1;
                if (rndInt == 6) {
                    damageAmount--;
                }
            }
        }
        setStrength(getStrength() - damageAmount);
        return "You take "+damageAmount+" damage!";
    }

    @Override
    public String toString() {
        return "Player{" +
            "speed=" + getSpeed() +
            ", strength=" + getStrength() +
            '}';
    }
}
