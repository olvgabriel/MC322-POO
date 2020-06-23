package game.labyrinth;

public class Checkpoint extends LabyrinthObject {
    Boolean conquered;

    Checkpoint(Integer x, Integer y) {
        super(x, y);
        conquered = false;
    }

    public Boolean isConquered() {
        return this.conquered;
    }

    void conquer() {
        conquered = true;
    }
}