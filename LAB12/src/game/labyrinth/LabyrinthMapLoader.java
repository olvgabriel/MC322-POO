package game.labyrinth;

public class LabyrinthMapLoader {
    private static LabyrinthMapLoader instance;

    private LabyrinthMapLoader() {

    }

    public static LabyrinthMapLoader getInstance() {
        if (instance == null) {
            instance = new LabyrinthMapLoader(); 
        }
        return instance;
    }

    /*
    public LabyrinthMap LoadMapFromFile(String path) {

    }
    */

    
    public LabyrinthMap createDefaultMap() {
        Player player = new Player(1, 1);

        Checkpoint checkpoint1 = new Checkpoint(2, 5);
        Checkpoint checkpoint2 = new Checkpoint(5, 5);
        Checkpoint checkpoint3 = new Checkpoint(1, 3);
        Checkpoint[] checkpoints = new Checkpoint[3];
        checkpoints[0] = checkpoint1;
        checkpoints[1] = checkpoint2;
        checkpoints[2] = checkpoint3;

        Wall wall1 = new Wall(4, 9);
        Wall wall2 = new Wall(8, 6);
        Wall wall3 = new Wall(3, 4);
        Wall wall4 = new Wall(6, 5);
        Wall[] walls = new Wall[4];
        walls[0] = wall1;
        walls[1] = wall2;
        walls[2] = wall3;
        walls[3] = wall4;
 
        LabyrinthMap map = new LabyrinthMap(10, 10, player, checkpoints, walls);

        return map;
    }
    

}