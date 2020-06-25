package game.labyrinth;

import game.engine.LabyrinthObjectVisitor;

public class Player extends LabyrinthObject {
    Direction currentDirection;

    // no modifier: pkg private
    Player(Integer x, Integer y) {
        super(x, y);
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    private boolean hasWallInPosition(int x, int y, Wall[] walls) {
        boolean hasWall = false;
        for (Wall wall : walls) {
            if (wall.isSameCoordinates(x, y)) {
                hasWall = true;
                break;
            }
        }
        return hasWall;
    }

    private boolean hasWall(Direction direction, Wall[] walls) {
        if (direction == Direction.UP) {
            return hasWallInPosition(this.getX(), this.getY()-1, walls);            
        } else if (direction == Direction.DOWN) {
            return hasWallInPosition(this.getX(), this.getY()+1, walls); 
        } else if (direction == Direction.LEFT) {
            return hasWallInPosition(this.getX()-1, this.getY(), walls); 
        } else { // direction == RIGHT
            return hasWallInPosition(this.getX()+1, this.getY(), walls); 
        }
    }

    // no modifier: pkg private
    void move(Direction direction, Wall[] walls) {
        if (hasWall(direction, walls) == false) {
            if (direction == Direction.UP) {
                this.coordinate.changeCoordinates(this.getX(), this.getY()-1);
            } else if (direction == Direction.DOWN) {
                this.coordinate.changeCoordinates(this.getX(), this.getY()+1);
            } else if (direction == Direction.LEFT) {
                this.coordinate.changeCoordinates(this.getX()-1, this.getY());
            } else { // direction == RIGHT
                this.coordinate.changeCoordinates(this.getX()+1, this.getY());
            }
            this.currentDirection = direction;
        }
    }
    
    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }
    
}