package game.engine;

import java.util.Scanner;

import game.labyrinth.Direction;
import game.labyrinth.LabyrinthMap;

public class TextEngine extends GameEngine {
    private TextRenderManager renderManager;

    public TextEngine(LabyrinthMap labyrinthMap) {
        super(labyrinthMap);
        renderManager = new TextRenderManager(labyrinthMap.getWidth(), labyrinthMap.getHeight());
    }
    
    public Direction readCommandFromKeyboard(Scanner scanner) {
        String command = scanner.next();
        if (command.equalsIgnoreCase("UP")) {
            return Direction.UP;
        } else if (command.equalsIgnoreCase("DOWN")) {
            return Direction.DOWN;
        } else if (command.equalsIgnoreCase("RIGHT")) {
            return Direction.RIGHT;
        } else if (command.equalsIgnoreCase("LEFT")) {
            return Direction.LEFT;
        } else {
            return null;
        }
    }

    @Override
    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        LabyrinthMap map = getLabyrinthMap();
        Direction newDirection;
        while (!map.isDone()) {
            renderManager.render(map);
            newDirection = readCommandFromKeyboard(scanner);
            map.updateMap(newDirection);
        }
        System.out.println("Labirinto finalizado! Parabens");
        scanner.close();
    }

}