
public class Position {

    int x;
    int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object o){
        if(o instanceof Position){
            return (x==((Position) o).getX() && y== ((Position) o).getY());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x + y;
    }
}
