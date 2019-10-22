package mocks;

public class Random extends java.util.Random {

    public Random() {}

    @Override
    public int nextInt() {
        return 5;
    }

    @Override
    public int nextInt(int bound) {
        return 5;
    }
}