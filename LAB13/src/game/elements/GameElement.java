package game.elements;

public class GameElement {
    private Coordinate coordinate;
    private String symbol;

    public GameElement(int x, int y) {
        coordinate = new Coordinate(x, y);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public String toString() {
        return this.getSymbol();
    }
}