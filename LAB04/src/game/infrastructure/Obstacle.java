package game.infrastructure;

public class Obstacle {
	
	private ObstacleType obstacleType;
	private int[] position = new int[2];
	
	public Obstacle(ObstacleType obstacleType, int x, int y) {
		this.obstacleType = obstacleType;
		position[0] = x;
		position[1] = y;
	}

	public ObstacleType getObstacleType() {
		return obstacleType;
	}

	public int[] getPosition() {
		return position;
	}
}
