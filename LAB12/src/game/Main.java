package game;

import game.engine.GameEngine;
import game.engine.TextEngine;
import game.labyrinth.LabyrinthMap;
import game.labyrinth.LabyrinthMapLoader;

public class Main {
    
    private static void runGame(GameEngine gameEngine) {
        gameEngine.gameLoop();
    }

    public static void main(String[] args) {
        LabyrinthMap map = LabyrinthMapLoader.getInstance().createDefaultMap();
        runGame(new TextEngine(map));
    }

}