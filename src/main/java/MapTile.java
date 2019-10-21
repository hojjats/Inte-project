public class MapTile {

    private Effect effect;
    private Enemy enemyOnTile;
    private Item itemOnTile;
    private static int discoveredTiles;
    private Position position;
    private String name;
    private MapTile northTile;
    private MapTile southTile;
    private MapTile eastTile;
    private MapTile westTile;

    // Effect can be null, no effect on tile
    public MapTile(Effect effect, String name, MapTile previousTile, Directions direction) {
        this(effect, name);
        if (previousTile == null)
            throw new IllegalArgumentException("PreviousTile can't be null");
        if (direction == null)
            throw new IllegalArgumentException("Direction can't be null");
        setPosition(previousTile, direction);
        setTile(previousTile, direction);
    }

    public MapTile(Effect effect, String name) {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        if (name.trim().equals(""))
            throw new IllegalArgumentException("Name can't be empty");
        this.effect = effect;
        this.position = new Position(0, 0);
        this.name = name;
        discoveredTiles++;
    }


    public void setTile(MapTile prev, Directions dir) {
        switch (dir) {
            case NORTH:
                this.setSouthTile(prev);
                prev.setNorthTile(this);
                break;
            case SOUTH:
                this.setNorthTile(prev);
                prev.setSouthTile(this);
                break;
            case EAST:
                this.setWestTile(prev);
                prev.setEastTile(this);
                break;
            case WEST:
                this.setEastTile(prev);
                prev.setWestTile(this);
                break;
        }
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

    public int getDiscoveredTiles() {
        return discoveredTiles;
    }

    public void setDiscoveredTiles(int discoveredTiles) {
        this.discoveredTiles = discoveredTiles;
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

    public void setNorthTile(MapTile northTile) {
        this.northTile = northTile;
    }

    public void setSouthTile(MapTile southTile) {
        this.southTile = southTile;
    }

    public void setEastTile(MapTile eastTile) {
        this.eastTile = eastTile;
    }

    public void setWestTile(MapTile westTile) {
        this.westTile = westTile;
    }
}
