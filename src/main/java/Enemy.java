public class Enemy extends Creature {

    private boolean isAggressive;
    private String name;
    private Dice dice;

    public Enemy(String name, int strength, int speed, boolean isAggressive) {
        this(name, strength, speed, isAggressive, new Dice());
    }

    public Enemy(String name, int strength, int speed, boolean isAggressive, Dice dice) {
        super(speed, strength);
        this.isAggressive = isAggressive;
        if (name == null || name.trim().length() == 0)
            throw new IllegalArgumentException("Enemy must have a name");
        if (name.length() > 20)
            throw new IllegalArgumentException("Enemy name is too long");
        this.name = name;
        this.dice = dice;
    }

    public Enemy(Dice dice) {
        this("Grunt", 2, 5, false, dice);
    }

    public Enemy() {
        this("Grunt", 2, 5, false);
    }

    public int attack() {
        return dice.roll(getStrength(), 6);
    }

    public String getName() {
        return name;
    }

    public boolean isAggressive() {
        return isAggressive;
    }

    public String takeDamage(int damageAmount) {
        if (getStrength() <= damageAmount) {
            die();
            return String.format("%s takes %d damage and Dies!",name,damageAmount);
        }
        setStrength(getStrength() - damageAmount);
        return String.format("%s takes %d damage",name,damageAmount);
    }

    public Dice getDice() {
        return dice;
    }


}
