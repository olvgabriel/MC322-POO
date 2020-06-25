package game.engine;

import game.labyrinth.LabyrinthMap;

public abstract class GameEngine { // Esta classe tem a proposta de generalizar como o labirinto será visualizado e gerenciado.
    private LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
        this.labyrinthMap = labyrinthMap;
    }

    protected LabyrinthMap getLabyrinthMap() {
        return this.labyrinthMap;
    }

    public abstract void gameLoop();

    

}