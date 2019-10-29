import java.util.Objects;

public class MapTile {

    private Effect effect;
    private Enemy enemyOnTile;
    private Item itemOnTile;
    private int discoveredTiles;
    private Position position;
    private final String name;
    private MapTile northTile, southTile, eastTile, westTile;
    private final int DIFFICULTY_MODIFIER = 5, ITEM_OCCURRENCE = 3, ITEM_TYPE_ALTERNATION = 2;

    // Effect can be null, no effect on tile
    public MapTile(Effect effect, String name, MapTile previousTile, Directions direction, int discoveredTiles) {
        this(effect, name);
        if (previousTile == null)
            throw new IllegalArgumentException("PreviousTile can't be null");
        if (direction == null)
            throw new IllegalArgumentException("Direction can't be null");
        if (discoveredTiles <= 0)
            throw new IllegalArgumentException("Discovered tiles can't be zero or less");
        this.discoveredTiles = discoveredTiles;
        setPositionFromDirection(previousTile, direction);
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
        this.discoveredTiles = 1;
        putEnemyOnTile();
        putItemOnTile();
    }


    private void setTile(MapTile previousTile, Directions direction) {
        switch (direction) {
            case NORTH:
                this.setSouthTile(previousTile);
                previousTile.setNorthTile(this);
                break;
            case SOUTH:
                this.setNorthTile(previousTile);
                previousTile.setSouthTile(this);
                break;
            case EAST:
                this.setWestTile(previousTile);
                previousTile.setEastTile(this);
                break;
            case WEST:
                this.setEastTile(previousTile);
                previousTile.setWestTile(this);
                break;
        }
    }


    private void setPositionFromDirection(MapTile previousTile, Directions direction) {
        Position position = new Position(previousTile.getPosition().getX(), previousTile.getPosition().getY());
        switch (direction) {
            case EAST:
                position.setX(position.getX() + 1);
                break;
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
        }
        this.position = position;
    }

    public void putEnemyOnTile() {
        int strength = (discoveredTiles / DIFFICULTY_MODIFIER) + 1;
        int speed = 1;
        enemyOnTile = new Enemy("Slime", strength, speed, true);
    }

    public void putItemOnTile() {
        int itemTier = (discoveredTiles / DIFFICULTY_MODIFIER) + 1;
        if (discoveredTiles % ITEM_OCCURRENCE == 0) {
            itemOnTile = discoveredTiles % ITEM_TYPE_ALTERNATION == 0 ? new Armor("Shield", itemTier) : new Weapon("Sword", itemTier);
        }
    }

    public Enemy getEnemyOnTile() {
        return enemyOnTile;
    }

    public Item getItemOnTile() {
        return itemOnTile;
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

    //Just to make tests
    void setDiscoveredTiles(int discoveredTiles) {
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
        if (northTile == null)
            throw new IllegalArgumentException("Tile can't be set to null");
        this.northTile = northTile;
    }

    public void setSouthTile(MapTile southTile) {
        if (southTile == null)
            throw new IllegalArgumentException("Tile can't be set to null");
        this.southTile = southTile;
    }

    public void setEastTile(MapTile eastTile) {
        if (eastTile == null)
            throw new IllegalArgumentException("Tile can't be set to null");
        this.eastTile = eastTile;
    }

    public void setWestTile(MapTile westTile) {
        if (westTile == null)
            throw new IllegalArgumentException("Tile can't be set to null");
        this.westTile = westTile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapTile)) return false;
        MapTile mapTile = (MapTile) o;
        return position.equals(mapTile.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
