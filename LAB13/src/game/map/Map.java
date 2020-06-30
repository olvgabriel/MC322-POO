package game.map;


import game.elements.Collectable;
import game.elements.GameElement;
import game.elements.Rechargable;
import game.elements.empty.Empty;
import game.elements.jewels.*;
import game.elements.obstacles.*;
import game.elements.robot.Robot;
import game.error.PositionOcupedException;

public class Map {

    private GameElement[][] map;
    private Robot robot;

    public Map(int altura, int largura) {
        map = new GameElement[altura][largura];
    }

    /* #################### CRIANDO E INSERINDO ELEMENTOS NO MAPA ######################## */
    public void createDefaultJewels() {
        // creates default jewels
        Jewel jewel_1 = new Jewel(JewelType.RED, 1, 9);
		Jewel jewel_2 = new Jewel(JewelType.RED, 8, 8);
		Jewel jewel_3 = new Jewel(JewelType.GREEN, 9, 1);
		Jewel jewel_4 = new Jewel(JewelType.GREEN, 7, 6);
		Jewel jewel_5 = new Jewel(JewelType.BLUE, 3, 4);
        Jewel jewel_6 = new Jewel(JewelType.BLUE, 2, 1);
        
        // insert defautl jewels
        insertJewel(jewel_1);
        insertJewel(jewel_2);
        insertJewel(jewel_3);
        insertJewel(jewel_4);
        insertJewel(jewel_5);
        insertJewel(jewel_6);
    }

    public void createDefaultObstacles() {
        // creates default obstacles
        Obstacle obstacle_1 = new Obstacle(ObstacleType.WATER, 5, 0);
		Obstacle obstacle_2 = new Obstacle(ObstacleType.WATER, 5, 1);
		Obstacle obstacle_3 = new Obstacle(ObstacleType.WATER, 5, 2);
		Obstacle obstacle_4 = new Obstacle(ObstacleType.WATER, 5, 3);
		Obstacle obstacle_5 = new Obstacle(ObstacleType.WATER, 5, 4);
		Obstacle obstacle_6 = new Obstacle(ObstacleType.WATER, 5, 5);
		Obstacle obstacle_7 = new Obstacle(ObstacleType.WATER, 5, 6);
		Obstacle obstacle_8 = new Obstacle(ObstacleType.TREE, 5, 9);
		Obstacle obstacle_9 = new Obstacle(ObstacleType.TREE, 3, 9);
		Obstacle obstacle_10 = new Obstacle(ObstacleType.TREE, 8, 3);
		Obstacle obstacle_11 = new Obstacle(ObstacleType.TREE, 2, 5);
        Obstacle obstacle_12 = new Obstacle(ObstacleType.TREE, 1, 4);
        
        // insert default obstacles
        insertObstacle(obstacle_1);
        insertObstacle(obstacle_2);
        insertObstacle(obstacle_3);
        insertObstacle(obstacle_4);
        insertObstacle(obstacle_5);
        insertObstacle(obstacle_6);
        insertObstacle(obstacle_7);
        insertObstacle(obstacle_8);
        insertObstacle(obstacle_9);
        insertObstacle(obstacle_10);
        insertObstacle(obstacle_11);
        insertObstacle(obstacle_12);
    }

    public void createDefaultRobot() {
        Robot robot = new Robot(0, 9);
        this.robot = robot;
        insertRobot(robot);
    }

    public void insertJewel(Jewel jewel) {
        map[jewel.getX()][jewel.getY()] = jewel;
    }

    public void insertObstacle(Obstacle obstacle) {
        map[obstacle.getX()][obstacle.getY()] = obstacle;
    }

    public void insertRobot(Robot robot) {
        map[robot.getX()][robot.getY()] = robot;
    }


    /* ############################ PRINTANDO O MAPA ################################## */
    private void insertEmpty() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    map[i][j] = new Empty(i, j);
                }
            }
        }
    }

    public void print() {
        insertEmpty();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Bag total items: " + robot.totalItems() + " | Bag total value: " + robot.getTotalValue());
        System.out.print("Energy: " + robot.getEnergy() + " | ");
    }

    /* ######################### MOVIMENTO DO ROBO #################### */
    private void moveRobot(int x, int y) {
        map[x][y] = this.robot;
        this.robot.getCoordinate().changeCoordinates(x, y);
        this.robot.decreaseEnergy();
    }

    private boolean isValidPosition(int x, int y) {
        if (x < 0 || x >= map.length) {
            return false;
        } else if (y < 0 || y >= map[0].length) {
            return false;
        } else {
            return true;
        }
    }

    public void emptyPosition(int x, int y) {
        map[x][y] = new Empty(x, y);
    }

    private boolean hasObstacle(int x, int y) {
        if (this.map[x][y].getSymbol() == "--") {
            return false;
        } else {
            return true;
        }
    }


    public void moveRobotToEast() {
        if (this.robot.hasPointsOfEnergy()) {
            if (isValidPosition(robot.getX(), robot.getY()+1) && !hasObstacle(robot.getX(), robot.getY()+1)) {
                emptyPosition(robot.getX(), robot.getY());
            }
            try {
                if (hasObstacle(robot.getX(), robot.getY()+1)) {
                    throw new PositionOcupedException("Invalid Position: Has obstacle!");
                }
                moveRobot(robot.getX(), robot.getY()+1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Position: ArrayIndexOutOfBoundsException");
            } catch (PositionOcupedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void moveRobotToWest() {
        if (this.robot.hasPointsOfEnergy()) {
            if (isValidPosition(robot.getX(), robot.getY()-1) && !hasObstacle(robot.getX(), robot.getY()-1)) {
                emptyPosition(robot.getX(), robot.getY());
            }
            try {
                if (hasObstacle(robot.getX(), robot.getY()-1)) {
                    throw new PositionOcupedException("Invalid Position: Has obstacle!");
                }
                moveRobot(robot.getX(), robot.getY()-1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Position: ArrayIndexOutOfBoundsException");
            } catch (PositionOcupedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void moveRobotToNorth() {
        if (this.robot.hasPointsOfEnergy()) {
            if (isValidPosition(robot.getX()-1, robot.getY()) && !hasObstacle(robot.getX()-1, robot.getY())) {
                emptyPosition(robot.getX(), robot.getY());
            }
            try {
                if (hasObstacle(robot.getX()-1, robot.getY())) {
                    throw new PositionOcupedException("Invalid Position: Has obstacle!");
                }
                moveRobot(robot.getX()-1, robot.getY());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Position: ArrayIndexOutOfBoundsException");
            } catch (PositionOcupedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void moveRobotToSouth() {
        if (this.robot.hasPointsOfEnergy()) {
            if (isValidPosition(robot.getX()+1, robot.getY()) && !hasObstacle(robot.getX()+1, robot.getY())) {
                emptyPosition(robot.getX(), robot.getY());
            }
            try {
                if (hasObstacle(robot.getX()+1, robot.getY())) {
                    throw new PositionOcupedException("Invalid Position: Has obstacle!");
                }
                moveRobot(robot.getX()+1, robot.getY());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Position: ArrayIndexOutOfBoundsException");
            } catch (PositionOcupedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public JewelType jewelTypeOnMap(int x, int y) {
        if (map[x][y].getSymbol() == "JR") {
            return JewelType.RED;
        } else if (map[x][y].getSymbol() == "JB") {
            return JewelType.BLUE; 
        } else {
            return JewelType.GREEN;
        }
    }

    public void collect() {
        if (isValidPosition(robot.getX()-1, robot.getY())) { // direction == up
            Collectable collectable = getCollectable(robot.getX()-1, robot.getY());
            if (collectable != null) {
                collectable.collect(this.robot, this);
            }
        }  
        if (isValidPosition(robot.getX()+1, robot.getY())) { // direction == down
            Collectable collectable = getCollectable(robot.getX()+1, robot.getY());
            if (collectable != null) {
                collectable.collect(this.robot, this);
            }
        }  
        if (isValidPosition(robot.getX(), robot.getY()+1)) { // direction == east
            Collectable collectable = getCollectable(robot.getX(), robot.getY()+1);
            if (collectable != null) {
                collectable.collect(this.robot, this);
            }
        }  
        if (isValidPosition(robot.getX(), robot.getY()-1)) { // direction == east
            Collectable collectable = getCollectable(robot.getX(), robot.getY()-1);
            if (collectable != null) {
                collectable.collect(this.robot, this);
            }
        } 
    }

    public void recharge() {
        if (isValidPosition(robot.getX()-1, robot.getY())) { // direction == up
            Rechargable rechargable = getRechargable(robot.getX()-1, robot.getY());
            if (rechargable != null) {
                rechargable.recharge(this.robot);
            }
        }  
        if (isValidPosition(robot.getX()+1, robot.getY())) { 
            Rechargable rechargable = getRechargable(robot.getX()+1, robot.getY());
            if (rechargable != null) {
                rechargable.recharge(this.robot);
            }
        }  
        if (isValidPosition(robot.getX(), robot.getY()+1)) {
            Rechargable rechargable = getRechargable(robot.getX(), robot.getY()+1);
            if (rechargable != null) {
                rechargable.recharge(this.robot);
            }
        } 
        if (isValidPosition(robot.getX(), robot.getY()-1)) { 
            Rechargable rechargable = getRechargable(robot.getX(), robot.getY()-1);
            if (rechargable != null) {
                rechargable.recharge(this.robot);
            }
        } 
    }

    public Rechargable getRechargable(int x, int y) {
        if (map[x][y].getSymbol() == "JB") {
            return new Jewel(JewelType.BLUE, x, y);
        } else if (map[x][y].getSymbol() == "$$") {
            return new Obstacle(ObstacleType.TREE, x, y);
        } else {
            return null;
        }
    }

    public Collectable getCollectable(int x, int y) {
        if (map[x][y].getSymbol() == "JR") {
            return new Jewel(JewelType.RED, x, y);
        } else if (map[x][y].getSymbol() == "JB") {
            return new Jewel(JewelType.BLUE, x, y);
        } else if (map[x][y].getSymbol() == "JG") {
            return new Jewel(JewelType.GREEN, x, y);
        } else {
            return null;
        }
    }

    public boolean isRechargable(int x, int y) {
        if (map[x][y].getSymbol() == "JB" || map[x][y].getSymbol() == "$$") {
            return true;
        } else {
            return false;
        }
    }

}