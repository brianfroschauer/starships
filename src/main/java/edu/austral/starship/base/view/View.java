package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.Entity;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 31/10/2018
 */
public abstract class View<T extends Entity<T>> {

    private final T entity;
    private final PImage image;

    View(T entity, PImage image) {
        this.entity = entity;
        this.image = image;
    }

    void draw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.translate(entity.getPosition().x(), entity.getPosition().y());
        graphics.rotate(entity.getDirection().angle() + PConstants.PI/2);
        graphics.imageMode(PConstants.CENTER);
        graphics.image(image, 0, 0);
        graphics.popMatrix();

        getRelativeDraw(graphics);
    }

    abstract void getRelativeDraw(PGraphics graphics);

    public T getEntity() {
        return entity;
    }
}