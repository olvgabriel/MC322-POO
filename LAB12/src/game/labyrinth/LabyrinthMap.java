package game.labyrinth;

import game.engine.LabyrinthObjectVisitor;

public class LabyrinthMap {
    private Player player;
    private Checkpoint[] checkpoints;
    private Wall[] walls;
    private Integer width; // comprimento
    private Integer height; // altura

    protected LabyrinthMap(Integer width, Integer height, Player player, Checkpoint[] checkpoints, Wall[] walls) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.checkpoints = checkpoints;
        this.walls = walls;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    private boolean isValidPosition(int x, int y) {
        if (x > 0 && x <= this.height) {
            if (y > 0 && y <= this.width) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    private boolean isValidMovement(Direction direction) {
        if (direction == Direction.UP) {
            return isValidPosition(player.getX()-1, player.getY());
        } else if (direction == Direction.DOWN) {
            return isValidPosition(player.getX()+1, player.getY());
        } else if (direction == Direction.LEFT) {
            return isValidPosition(player.getX(), player.getY()-1);
        } else { // direction == RIGHT
            return isValidPosition(player.getX(), player.getY()+1);
        }
    }

    public void updateMap(Direction direction) {  // direction == UP
        if (direction != null) {
            if (isValidMovement(direction)) {
                player.move(direction, walls);
            }
        }
    }

    public Boolean isDone() {
        boolean isDone = true;
        for (Checkpoint checkpoint : checkpoints) {
            if (checkpoint.isConquered() == false) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    public void accept(LabyrinthObjectVisitor visitor) {
        for (Wall wall : walls) {
            wall.accept(visitor);
        }
        for (Checkpoint checkpoint : checkpoints) {
            checkpoint.accept(visitor);
        }
        player.accept(visitor);
    }

}