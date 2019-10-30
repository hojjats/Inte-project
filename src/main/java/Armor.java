public class Armor extends Item {

    private int armorRating;

    public Armor(String name, int armorRating) {
        super(name);
        this.armorRating = armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }
}
