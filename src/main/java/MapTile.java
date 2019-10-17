public class MapTile {

    private Effect effect;
    private Position position;
    private MapTile northTile;
    private MapTile southTile;
    private MapTile eastTile;
    private MapTile westTile;

    // Effect can be null, no effect on tile
    public MapTile(Effect effect, Position position) {
        if(position == null)
            throw new IllegalArgumentException("Position can't be null ");
        this.effect = effect;
        this.position = position;
    }

    public Effect getEffect() {
        return effect;
    }

    public Position getPosition() {
        return position;
    }
}
