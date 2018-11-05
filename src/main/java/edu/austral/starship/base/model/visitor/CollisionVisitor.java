package edu.austral.starship.base.model.visitor;

import edu.austral.starship.base.model.entity.Asteroid;
import edu.austral.starship.base.model.entity.Bullet;
import edu.austral.starship.base.model.entity.Entity;
import edu.austral.starship.base.model.entity.Starship;

/**
 * Author: brianfroschauer
 * Date: 26/10/2018
 */
public class CollisionVisitor implements Visitor {

    private final Entity<?> entity;

    public CollisionVisitor(Entity<?> entity) {
        this.entity = entity;
    }

    @Override
    public void visitStarship(Starship starship) {
        entity.collisionedWithStarship(starship);
    }

    @Override
    public void visitAsteroid(Asteroid asteroid) {
        entity.collisionedWithAsteroid(asteroid);
    }

    @Override
    public void visitBullet(Bullet bullet) {
        entity.collisionedWithBullet(bullet);
    }
}