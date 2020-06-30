package game.elements.empty;

import game.elements.GameElement;

public class Empty extends GameElement {
    
    public Empty(int x, int y) {
        super(x, y);
        setSymbol();
    }

    private void setSymbol() {
        this.setSymbol("--");
    }
}