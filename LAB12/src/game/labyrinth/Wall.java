package game.labyrinth;

import game.engine.LabyrinthObjectVisitor;

public class Wall extends LabyrinthObject {
    
    // no modifier: pkg private
    Wall(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }
}