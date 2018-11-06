package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;
import edu.austral.starship.base.model.visitor.Visitor;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public class Asteroid extends Entity<Asteroid> implements Harmful {

    private int life;

    public Asteroid(Vector2 position, Vector2 direction, float speed, int life) {
        super(position, direction, speed);
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    @Override
    protected Shape getRelativeShape() {
        return new Ellipse2D.Float(position.x(), position.y(),
                Constants.ASTEROID_WIDTH, Constants.ASTEROID_HEIGHT);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        position = position.add(direction.rotate(starship.direction.angle()).unitary());

    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {
        position = position.add(direction.rotate(asteroid.direction.angle()).unitary());
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {
        life -= bullet.getDamage();
    }

    @Override
    public void update(float timeSinceLastDraw) {
        final float distance = timeSinceLastDraw * (Constants.GRAVITY + speed);
        position = position.add(direction.multiply(distance));
        checkBounds();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAsteroid(this);
    }

    @Override
    public int getDamage() {
        return Constants.ASTEROID_DAMAGE;
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }
}