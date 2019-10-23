import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiceTest {

    Dice loadedDice = new Dice(new mocks.Random(6));

    @Test
    void rollMultiple(){
        assertEquals(3, loadedDice.roll(3,6));
    }

    @Test
    void rollSingle(){
        assertEquals(1, loadedDice.roll(1,6));
    }

}
