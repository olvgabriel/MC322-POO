package game.player;

public class Robot {
	
	private int[] position = new int[2];
	private Bag bag;
	
	public Robot(int x, int y) {
		position[0] = x;
		position[1] = y;
		bag = new Bag();
	}
	
	public int bagItems() {
		int quantidadeItems = bag.getItems();
		return quantidadeItems;
	}
	
	public void addItem() {
		bag.setItems(bag.getItems()+1);
	}
	
	public int bagValue() {
		int valorItems = bag.getValue();
		return valorItems;
	}
	
	public void addBagValue(int value) {
		bag.setValue(bag.getValue()+value);
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getPositionX() {
		return position[0];
	}
	
	public int getPositionY() {
		return position[1];
	}
	
	public void setPositionX(int x) {
		position[0] = x;
	}
	
	public void setPositionY(int y) {
		position[1] = y;
	}
	
	
}
