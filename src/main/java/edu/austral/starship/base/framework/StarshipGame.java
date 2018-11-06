package edu.austral.starship.base.framework;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.util.constants.Constants;

import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class StarshipGame implements GameFramework {

    private final Set<Integer> keySet = new HashSet<>();
    private final GameController gameController = new GameController();

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        gameController.setup(imageLoader);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        gameController.draw(graphics);
        gameController.update(timeSinceLastDraw);
        gameController.keyPressed(keySet);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        keySet.add(event.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keySet.remove(event.getKeyCode());
    }
}