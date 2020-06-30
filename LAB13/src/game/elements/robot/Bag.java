package game.elements.robot;

import java.util.ArrayList;

import game.elements.jewels.Jewel;



public class Bag {
    
    private ArrayList<Jewel> items;

    public Bag() {
        items = new ArrayList<Jewel>();
    }

    public ArrayList<Jewel> getItems() {
        return this.items;
    }

    public void addItem(Jewel jewel) {
        items.add(jewel);
    }

    public int getNumberJewels() {
        return items.size();
    }

    public int getTotalValue() {
        int totalValue = 0;
        for (Jewel jewel : items) {
            totalValue += jewel.getValue();
        }
        return totalValue;
    }

}