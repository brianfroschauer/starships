package edu.austral.starship.base.model.visitor;

import edu.austral.starship.base.model.entity.*;

/**
 * Author: brianfroschauer
 * Date: 26/10/2018
 */
public class CollisionVisitor<T extends Entity> implements Visitor {

    private final T entity;

    public CollisionVisitor(T entity) {
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

    @Override
    public void visitWeaponUpgrade(WeaponUpgrade weaponUpgrade) {
        entity.collisionedWithWeaponUpgrade(weaponUpgrade);
    }
}