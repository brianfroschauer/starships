package edu.austral.starship.base.collision;

import java.awt.*;

public interface Collisionable<T extends Collisionable<T>> {

    void collisionedWith(T collisionable);
    Shape getShape();
}
