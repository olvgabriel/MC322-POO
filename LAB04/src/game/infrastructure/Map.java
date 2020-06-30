package game.infrastructure;

import game.player.Robot;

public class Map {
	
	private String[][] map;
	private int altura;
	private int largura;
	private Jewel[] jewels;
	private Obstacle[] obstacles;
	private Robot robot;
	
	public Map(int altura, int largura) {
		this.altura = altura;
		this.largura = largura;
		map = new String[altura][largura];
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				map[i][j] = "--";
			}
		}
	}
	
	public void printMap() {
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				System.out.printf(map[i][j]);
				if (j < largura-1) {
					System.out.printf(" ");
				}
			}
			System.out.printf("\n");
		}
		System.out.printf("Bag total items: %d | Bag total value: %d\n", robot.bagItems(), robot.bagValue());
		System.out.printf("Enter the command: ");
	}
	
	
	
	public void insertJewels() {
		jewels = new Jewel[6];

		jewels[0] = new Jewel(JewelType.RED, 1, 9);
		jewels[1] = new Jewel(JewelType.RED, 8, 8);
		jewels[2] = new Jewel(JewelType.GREEN, 9, 1);
		jewels[3] = new Jewel(JewelType.GREEN, 7, 6);
		jewels[4] = new Jewel(JewelType.BLUE, 3, 4);
		jewels[5] = new Jewel(JewelType.BLUE, 2, 1);
		
		for (int i = 0; i < 6; i++) {
			addJewel(jewels[i]);
		}
	}
	
	private void addJewel(Jewel jewel) {
		int posX = jewel.getPosition()[0];
		int posY = jewel.getPosition()[1];
		if (jewel.getJewelType() == JewelType.RED) {
			map[posX][posY] = "JR";
		} else if (jewel.getJewelType() == JewelType.GREEN) {
			map[posX][posY] = "JG";
		} else {
			map[posX][posY] = "JB";
		}
	}
	
	// Inst�ncia os obst�culos e chama a f�. p/ adicionar as Strings no mapa.
	public void insertObstacles() {
		obstacles = new Obstacle[12];
		
		obstacles[0] = new Obstacle(ObstacleType.WATER, 5, 0);
		obstacles[1] = new Obstacle(ObstacleType.WATER, 5, 1);
		obstacles[2] = new Obstacle(ObstacleType.WATER, 5, 2);
		obstacles[3] = new Obstacle(ObstacleType.WATER, 5, 3);
		obstacles[4] = new Obstacle(ObstacleType.WATER, 5, 4);
		obstacles[5] = new Obstacle(ObstacleType.WATER, 5, 5);
		obstacles[6] = new Obstacle(ObstacleType.WATER, 5, 6);
		obstacles[7] = new Obstacle(ObstacleType.TREE, 5, 9);
		obstacles[8] = new Obstacle(ObstacleType.TREE, 3, 9);
		obstacles[9] = new Obstacle(ObstacleType.TREE, 8, 3);
		obstacles[10] = new Obstacle(ObstacleType.TREE, 2, 5);
		obstacles[11] = new Obstacle(ObstacleType.TREE, 1, 4);
		
		
		for (int i = 0; i < 12; i++) {
			addObstacles(obstacles[i]);
		}
	}
	
	// Coloca os obst�culos (String) no mapa.
	private void addObstacles(Obstacle obstacle) {
		int posX = obstacle.getPosition()[0];
		int posY = obstacle.getPosition()[1];
		if (obstacle.getObstacleType() == ObstacleType.TREE) {
			map[posX][posY] = "$$";
		} else {
			map[posX][posY] = "##";
		}
	}
	
	public void createRobot() {
		robot = new Robot(0, 0);
		moveRobot();
	}
	
	public void moveRobot() {
		int[] position  = robot.getPosition();
		map[position[0]][position[1]] = "ME";
	}

// MOVIMENTA��O DO R�BO ###################################
	private void clearPosition() {
		map[robot.getPositionX()][robot.getPositionY()] = "--";
	}
	
	private boolean isJewel(int x, int y) {
		if (map[x][y] == "JR" || map[x][y] == "JG" || map[x][y] == "JB") {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	private String verificaJewel(int x, int y) {
		String jewel;
		if (map[x][y] == "JR") {
			return "JR";
		} else if (map[x][y] == "JG") {
			return "JG";
		} else if (map[x][y] == "JB") {
			return "JB";
		} else {
			return "null";
		}
	}
	*/
	
	public void moveRobotToEast() {
		if (robot.getPositionY() < 9 
				&& map[robot.getPositionX()][robot.getPositionY()+1] != "$$" 
				&& map[robot.getPositionX()][robot.getPositionY()+1] != "##" && !isJewel(robot.getPositionX(), robot.getPositionY()+1)) {
			clearPosition();
			robot.setPositionY(robot.getPositionY()+1);
		}
		moveRobot();
	}
	
	public void moveRobotToSouth() {
		if (robot.getPositionX() < 9
				&& map[robot.getPositionX()+1][robot.getPositionY()] != "$$" 
				&& map[robot.getPositionX()+1][robot.getPositionY()] != "##" && !isJewel(robot.getPositionX()+1, robot.getPositionY())) {
			clearPosition();
			robot.setPositionX(robot.getPositionX()+1);
		}
		moveRobot();
	}
	
	public void moveRobotToNorth() {
		if (robot.getPositionX() > 0
				&& map[robot.getPositionX()-1][robot.getPositionY()] != "$$" 
				&& map[robot.getPositionX()-1][robot.getPositionY()] != "##" && !isJewel(robot.getPositionX()-1, robot.getPositionY())) {
			clearPosition();
			robot.setPositionX(robot.getPositionX()-1);
		}
		moveRobot();
	}
	
	public void moveRobotToWest() {
		if (robot.getPositionY() > 0 
				&& map[robot.getPositionX()][robot.getPositionY()-1] != "$$" 
				&& map[robot.getPositionX()][robot.getPositionY()-1] != "##" && !isJewel(robot.getPositionX(), robot.getPositionY()-1)) {
			clearPosition();
			robot.setPositionY(robot.getPositionY()-1);
		}
		moveRobot();
	}
	
// COLETA DAS JOIAS #################################
	public void collectJewel() {
		int robotPositionX = robot.getPositionX();
		int robotPositionY = robot.getPositionY();
		
		for (int i = robotPositionX-1; i <= robotPositionX+1; i++) {
			for (int j = robotPositionY-1; j <= robotPositionY+1; j++) {
				if (validatePosition(i, j) && hasJewel(i, j)) {
					int value = whatJewelPoint(i, j);
					robot.addBagValue(value);
					robot.addItem();
					map[i][j] = "--";
				}
			}
		}
	}
	
	private boolean validatePosition(int x, int y) {
		if (x < 0 || x > 9) {
			return false;
		} else if (y < 0 || y > 9) {
			return false;
		} else {
			return true;
		}
	}
	
	private boolean hasJewel(int x, int y) {
		if (map[x][y] == "JR" || map[x][y] == "JB" || map[x][y] == "JG") {
			return true;
		} else {
			return false;
		}
	}
	
	private int whatJewelPoint(int x, int y) {
		int value;
		if (map[x][y] == "JR") {
			value = 100;
		} else if (map[x][y] == "JG") {
			value = 50;
		} else {
			value = 10;
		}
		return value;
	}
}

	
