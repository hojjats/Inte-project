public class Map {

    private int dimensions;
    private Terrain[] terrains;

    public Map(int dimensions){
        this.dimensions = dimensions;
        terrains = randomizeTerrain(dimensions);
    }


    private Terrain[] randomizeTerrain(int dimensions) {
        // Do something
        return null;
    }


    @Override
    public String toString() {
        return "this map has "+dimensions*dimensions+" rooms to visit";
    }
}
