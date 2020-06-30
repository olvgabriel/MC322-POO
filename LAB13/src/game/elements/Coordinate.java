package game.elements;

public class Coordinate {
    private int x;
    private int y;

    // no modifier: private-pkg
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void changeCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}