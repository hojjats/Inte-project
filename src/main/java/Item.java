public abstract class Item {

    private String name;
    private int durability;
    private final int DEFAULT_DURABILITY = 100;

    public Item(String name) {
        this.name = name;
        this.durability = DEFAULT_DURABILITY;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int newDurability) {
        this.durability = newDurability;
    }

}
