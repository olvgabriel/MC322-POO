package game.infrastructure;

public class Jewel {
	
	private JewelType jewelType;  // jewelType
	private int[] position = new int[2];
	
	public Jewel(JewelType jewelType, int x, int y) {
		position[0] = x;
		position[1] = y;
		this.jewelType = jewelType;
	}

	public JewelType getJewelType() {
		return jewelType;
	}

	public int[] getPosition() {
		return position;
	}
	
	
}
