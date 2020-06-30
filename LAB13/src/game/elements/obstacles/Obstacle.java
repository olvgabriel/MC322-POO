package game.elements.obstacles;

import game.elements.GameElement;
import game.elements.Rechargable;
import game.elements.robot.Robot;

public class Obstacle extends GameElement implements Rechargable {
    
    private ObstacleType obstacleType;

    public Obstacle(ObstacleType obstacleType, int x, int y) {
        super(x, y);
        this.obstacleType = obstacleType;
        setSymbol();
    }

    private void setSymbol() {
        if (obstacleType == ObstacleType.TREE) {
            this.setSymbol("$$");
        } else {
            this.setSymbol("##");
        }
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    @Override
    public void recharge(Robot robot) {
        robot.addEnergy(this);
    }
}