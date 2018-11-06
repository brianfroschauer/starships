package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;
import edu.austral.starship.base.model.visitor.CollisionVisitor;
import edu.austral.starship.base.model.visitor.Visitable;

import java.awt.*;
import java.awt.geom.Path2D;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public abstract class Entity implements Collisionable<Entity>, Visitable {

    Vector2 position;
    Vector2 direction;
    float speed;

    Entity(Vector2 position, Vector2 direction, float speed) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    @Override
    public Shape getShape() {
        final Path2D.Float path = new Path2D.Float();
        path.append(getRelativeShape(), false);
        return path;
    }

    protected abstract Shape getRelativeShape();

    @Override
    public void collisionedWith(Entity collisionable) {
        collisionable.accept(new CollisionVisitor<>(this));
    }

    public abstract void collisionedWithStarship(Starship starship);

    public abstract void collisionedWithAsteroid(Asteroid asteroid);

    public abstract void collisionedWithBullet(Bullet bullet);

    public abstract void collisionedWithWeaponUpgrade(WeaponUpgrade weaponUpgrade);

    public abstract void update(float timeSinceLastDraw);

    public abstract boolean isDead();

    void checkBounds() {
        final int w = Constants.GAME_WIDTH;
        final int h = Constants.GAME_HEIGHT;
        if      (position.x() < 0) position.setX(w);
        else if (position.x() > w) position.setX(0);
        else if (position.y() < 0) position.setY(h);
        else if (position.y() > h) position.setY(0);
    }
}