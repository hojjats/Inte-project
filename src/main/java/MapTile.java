public class MapTile {

    private Effect effect;
    private Position position;
    private String name;
    private MapTile northTile;
    private MapTile southTile;
    private MapTile eastTile;
    private MapTile westTile;

    // Effect can be null, no effect on tile
    public MapTile(Effect effect, String name, MapTile previousTile, Directions direction) {
        this(effect, name);
        setPosition(previousTile, direction);
        // Setting of tile


    }

    public MapTile(Effect effect, String name) {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        if (name.trim().equals(""))
            throw new IllegalArgumentException("Name can't be empty");
        this.effect = effect;
        this.position = new Position(0, 0);
        this.name = name;
    }

    private void setTile(MapTile prev, Directions dir) {

    }

    private void setPosition(MapTile prev, Directions dir) {
        switch (dir) {
            case EAST:
                this.position = new Position(prev.getPosition().getX() + 1, prev.getPosition().getY());
                break;
            case NORTH:
                this.position = new Position(prev.getPosition().getX(), prev.getPosition().getY() + 1);
                break;
            case WEST:
                this.position = new Position(prev.getPosition().getX() - 1, prev.getPosition().getY());
                break;
            case SOUTH:
                this.position = new Position(prev.getPosition().getX(), prev.getPosition().getY() - 1);
                break;
        }
    }

    public Effect getEffect() {
        return effect;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public MapTile getNorthTile() {
        return northTile;
    }

    public MapTile getSouthTile() {
        return southTile;
    }

    public MapTile getEastTile() {
        return eastTile;
    }

    public MapTile getWestTile() {
        return westTile;
    }
}
