package game.engine;

import game.labyrinth.*;

public interface LabyrinthObjectVisitor {
    
    public void visit(Player player);
    public void visit(Wall wall);
    public void visit(Checkpoint checkpoint);
    
}