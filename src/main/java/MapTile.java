public class MapTile {

    private Effect effect;
    private Position position;
    private String name;
    private MapTile northTile;
    private MapTile southTile;
    private MapTile eastTile;
    private MapTile westTile;

    // Effect can be null, no effect on tile
    public MapTile(Effect effect, Position position, String name, MapTile previousTile, Directions direction) {
        this(effect, position, name);
        // Setting of tile

    }

    public MapTile(Effect effect, Position position, String name) {
        if (position == null)
            throw new IllegalArgumentException("Position can't be null ");
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        if (name.trim().equals(""))
            throw new IllegalArgumentException("Name can't be empty");
        this.effect = effect;
        this.position = position;
        this.name = name;


    }

    private void setTile(MapTile prev, Directions dir) {

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
