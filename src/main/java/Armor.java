public class Armor extends Item {

    int armorRating;

    public Armor(String name, int armorRating) {
        super(name);
        this.armorRating = armorRating;
    }

    public int getArmorRating(){
        return armorRating;
    }
}
