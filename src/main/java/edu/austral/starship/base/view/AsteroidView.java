package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.Asteroid;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 31/10/2018
 */
public class AsteroidView extends View<Asteroid> {

    AsteroidView(Asteroid asteroid, PImage image) {
        super(asteroid, image);
    }

    @Override
    public void getRelativeDraw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.text("Life " + getEntity().getLife(),
                getEntity().getPosition().x() - 25,
                getEntity().getPosition().y() + 50);
        graphics.popMatrix();
    }
}
