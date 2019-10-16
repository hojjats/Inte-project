public abstract class Movable {

    private Position position;

    public Movable(int x, int y) {
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public Position moveNorth(){
        Position tempPos = getPosition();
        tempPos.setY(tempPos.getY() - 1);

        return tempPos;
    }

    public Position moveSouth(){
        Position tempPos = getPosition();
        tempPos.setY(tempPos.getY() + 1);
        return tempPos;
    }

    public Position moveWest(){
        Position tempPos = getPosition();
        tempPos.setX(tempPos.getX() - 1);
        return tempPos;
    }

    public Position moveEast() {
        Position tempPos = getPosition();
        tempPos.setX(tempPos.getX() + 1);
        return tempPos;
    }
}
