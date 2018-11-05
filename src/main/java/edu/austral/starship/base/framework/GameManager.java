package edu.austral.starship.base.framework;

import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class GameManager extends PApplet {

    private final GameFramework starshipGame = new StarshipGame();
    private final Set<Integer> keySet = new HashSet<>();

    public void settings() {
        starshipGame.setup(new WindowSettings(this), new ImageLoader(this));
    }

    public void draw() {
        clear();

        final float timeSinceLastFrame = (frameRate / 60) * 100;
        starshipGame.draw(g, timeSinceLastFrame, keySet);
    }

    public void keyPressed(KeyEvent event) {
        keySet.add(event.getKeyCode());
        starshipGame.keyPressed(event);
    }

    public void keyReleased(KeyEvent event) {
        keySet.remove(event.getKeyCode());
        starshipGame.keyReleased(event);
    }
}