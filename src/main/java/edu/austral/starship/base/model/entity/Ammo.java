package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.model.visitor.Visitor;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Author: brianfroschauer
 * Date: 03/11/2018
 */
public class Ammo extends Entity<Ammo> {

    private int ammo;
    private boolean dead = false;

    public Ammo(Vector2 position, Vector2 direction, float speed, int ammo) {
        super(position, direction, speed);
        this.ammo = ammo;
    }

    @Override
    protected Shape getRelativeShape() {
        return new Rectangle2D.Float(position.x(), position.y(),
                Constants.AMMO_WIDTH, Constants.AMMO_HEIGHT);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        starship.getWeapon().reload(ammo);
        dead = true;
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {

    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {

    }

    @Override
    public void update(float timeSinceLastDraw) {

    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}