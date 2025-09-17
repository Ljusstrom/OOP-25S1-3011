package example.controller;

import example.model.Player;
import example.utils.Direction;
import example.view.GraphicsDemo;

public class Controller {
    private Player player;
    private GraphicsDemo gui;

    public Controller(GraphicsDemo gui) {
        this.player = new Player(0, 0);
        this.gui = gui;
    }

    public void handleMove(Direction direction) {
        System.out.println("handleMove");
        player.move(direction);
        gui.updateCanvas(player.getX(), player.getY());
    }

    public int getPlayerX() {
        return player.getX();
    }

    public int getPlayerY() {
        return player.getY();
    }

    public int getGridSize() {
        return player.getGridSize();
    }
}
