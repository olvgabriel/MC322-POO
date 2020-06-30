package game.elements.robot;

import game.elements.GameElement;
import game.elements.jewels.Jewel;

public class Robot extends GameElement {
    
    private Bag bag;
    private int pointsOfEnergy;

    public Robot(int x, int y) {
        super(x, y);
        bag = new Bag();
        this.pointsOfEnergy = 10;
        setSymbol();
    }

    private void setSymbol() {
        this.setSymbol("ME");
    }

    public void addItem(Jewel jewel) {
        bag.addItem(jewel);
    }

    public void addEnergy(GameElement e) {
        if (e.getSymbol() == "$$") {
            pointsOfEnergy += 3;
        } else if (e.getSymbol() == "JB") {
            pointsOfEnergy += 5;
        }
    }

    public void setPosition(int x, int y) {
        this.getCoordinate().changeCoordinates(x, y);
    }

    public boolean hasPointsOfEnergy() {
        return this.pointsOfEnergy > 0 ? true : false;
    }

    public void decreaseEnergy() {
        this.pointsOfEnergy -=1;
    }

    public int getEnergy() {
        return pointsOfEnergy;
    }

    public int totalItems() {
        return bag.getNumberJewels();
    }

    public int getTotalValue() {
        return bag.getTotalValue();
    }
}