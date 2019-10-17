public class MapTile {

    private Effect effect;
    private Position position;
    private MapTile northTile;
    private MapTile southTile;
    private MapTile eastTile;
    private MapTile westTile;

    public MapTile(Effect effect, Position position) {
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
