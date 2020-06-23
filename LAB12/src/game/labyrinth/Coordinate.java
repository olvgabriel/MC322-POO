package game.labyrinth;

public class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public void changeCoordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        if (this.x == x) {
            if (this.y == y) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate) {
            Coordinate coord = (Coordinate) obj;
            return coord.x == this.x && coord.y == this.y;
        } else {
            return false;
        }
    }
    

}