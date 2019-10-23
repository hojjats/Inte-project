package mocks;

public class Random extends java.util.Random {

    int returnValue;

    public Random(int value) {
        this.returnValue = value - 1;
    }

    @Override
    public int nextInt(int bound) {
        return returnValue;
    }
}