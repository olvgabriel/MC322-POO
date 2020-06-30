package game.elements.jewels;

import game.elements.Collectable;
import game.elements.GameElement;
import game.elements.Rechargable;
import game.elements.robot.Robot;
import game.map.Map;

public class Jewel extends GameElement implements Collectable, Rechargable {
    
    private JewelType jewelType;

    public Jewel(JewelType jewelType, int x, int y) {
        super(x, y);
        this.jewelType = jewelType;
        setSymbol();
    }

    private void setSymbol() {
        if (jewelType == JewelType.BLUE) {
            this.setSymbol("JB");
        } else if (jewelType == JewelType.GREEN) {
            this.setSymbol("JG");
        } else {
            this.setSymbol("JR");
        }
    }

    public JewelType getJewelType() {
        return jewelType;
    }

    public int getValue() {
        int points;
        if (jewelType == JewelType.RED) {
            points = 100;
        } else if (jewelType == JewelType.GREEN) {
            points = 50;
        } else { // jewelType = BLUE
            points = 10;
        }
        return points;
    }

    @Override
    public void collect(Robot robot, Map map) {
        robot.addItem(this);
        map.emptyPosition(this.getX(), this.getY());
    }

    @Override
    public void recharge(Robot robot) {
        robot.addEnergy(this);
    }


}