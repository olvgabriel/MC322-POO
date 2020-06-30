package game.elements;

import game.elements.robot.Robot;
import game.map.Map;

public interface Collectable {
    
    public void collect(Robot robot, Map map);
}