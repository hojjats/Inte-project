import java.util.Random;

public class Dice {

    private Random rnd;

    public Dice() {
        this(new Random());
    }

    public Dice(Random rnd) {
        this.rnd = rnd;
    }

    public int roll(int rolls, int wanted) {
        int successfulRolls = 0;
        for (int i = 0; i < rolls; i++) {
            int rndInt = rnd.nextInt(6) + 1;
            if (rndInt == wanted) {
                successfulRolls++;
            }
        }
        return successfulRolls;
    }

    public int rollDice() {
        return rnd.nextInt(6) + 1;
    }

}
