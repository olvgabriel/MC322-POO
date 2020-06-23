package game.labyrinth;

public abstract class LabyrinthObject {
    Coordinate coordinate;

    // no modifier: pkg private
    LabyrinthObject(Integer x, Integer y) {
        this.coordinate = new Coordinate(x, y);
    }

    public Integer getX() {
        return coordinate.getX();
    }

    public Integer getY() {
        return coordinate.getY();
    }

    protected Coordinate getCoordinate() {
        return coordinate;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        return coordinate.isSameCoordinates(x, y);
    }

    
    public Boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        return this.coordinate.equals(labyrinthObject.coordinate);
    }
    
}