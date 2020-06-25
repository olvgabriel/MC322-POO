package game.engine;

import game.labyrinth.Checkpoint;
import game.labyrinth.LabyrinthMap;
import game.labyrinth.LabyrinthObject;
import game.labyrinth.Player;
import game.labyrinth.Wall;

class TextRenderManager implements LabyrinthObjectVisitor {
    private char[][] charMap;

    // no modifier: private pkg
    TextRenderManager(int mapWidth, int mapHeight) {
        this.charMap = new char[mapHeight][mapWidth];
    }

    public void render(LabyrinthMap map) {
        clearMap();
        map.accept(this);
        printMap();        
    }

    private void clearMap() {
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                charMap[i][j] = '-';
            }
        }
    }

    private void printMap() {
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                System.out.print(charMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void setSymbol(LabyrinthObject obj, char character) {
        charMap[obj.getY()][obj.getX()] = character;
    }

    @Override
    public void visit(Player jogador) {
        setSymbol(jogador, 'J');
    }

    @Override
    public void visit(Wall parede) {
        setSymbol(parede, 'X');
    }

    @Override
    public void visit(Checkpoint checkpoint) {
        if (checkpoint.isConquered()) {
            setSymbol(checkpoint, 'T');
        } else {
            setSymbol(checkpoint, 'C');
        }
    }





    
}