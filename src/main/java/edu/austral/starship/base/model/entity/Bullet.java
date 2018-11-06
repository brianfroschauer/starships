package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;
import edu.austral.starship.base.model.visitor.Visitor;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public class Bullet extends Entity<Bullet> implements Harmful {

    private Shooter shooter;
    private boolean dead = false;

    public Bullet(Vector2 position, Vector2 direction, float speed, Shooter shooter) {
        super(position, direction, speed);
        this.shooter = shooter;
    }

    @Override
    protected Shape getRelativeShape() {
        return new Rectangle2D.Float(position.x(), position.y(),
                Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {

    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {
        shooter.addScore(Constants.SHOOT_SCORE);
        dead = true;
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {

    }

    @Override
    public void update(float timeSinceLastDraw) {
        final float translation = timeSinceLastDraw * speed;
        position = position.add(direction.multiply(translation));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBullet(this);
    }

    @Override
    public int getDamage() {
        return Constants.BULLET_DAMAGE;
    }

    @Override
    public boolean isDead() {
        final int w = Constants.GAME_WIDTH;
        final int h = Constants.GAME_HEIGHT;
        return (position.x() < 0 ||
                position.x() > w ||
                position.y() < 0 ||
                position.y() > h ||
                dead);
    }
}