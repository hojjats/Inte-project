public class Player extends Creature {

    private Weapon weapon;
    private Armor armor;

    public Player(){
        super(10,10);
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

    // TODO: Actual algo to calculate atk and dmg
    @Override
    public int attack() {
        int totalDamage = getStrength();
        if (weapon != null) {
            totalDamage += weapon.getDamage();
        }
        return totalDamage;
    }

    @Override
    public String takeDamage(int damageAmount) {
        if (armor != null) {
            damageAmount -= armor.getArmorRating();
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
