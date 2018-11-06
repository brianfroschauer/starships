package edu.austral.starship.base.collision;

import java.awt.*;

public interface Collisionable<T> {

    void collisionedWith(T collisionable);
    Shape getShape();
}
