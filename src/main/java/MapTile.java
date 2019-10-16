public abstract class MapTile {
    private boolean blocked;
    private int actionPointsCost;


    public MapTile(boolean blocked, int actionPointsCost) {
        this.blocked = blocked;
        this.actionPointsCost = actionPointsCost;
    }

    public int getActionPointsCost() {
        return actionPointsCost;
    }

    public boolean isBlocked() {
        return blocked;
    }
}


