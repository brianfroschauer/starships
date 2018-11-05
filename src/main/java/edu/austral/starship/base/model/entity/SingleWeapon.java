package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 29/10/2018
 */
public class SingleWeapon extends Weapon {

    @Override
    protected List<Bullet> relativeShoot(Shooter shooter, Starship starship) {
        final List<Bullet> bullets = new ArrayList<>();
        final Vector2 direction = starship.getDirection();
        final Vector2 position = new Vector2(starship.getPosition().x(), starship.getPosition().y()).add(direction.multiply(50f));
        final float speed = 0.1f;
        bullets.add(new Bullet(position, direction, speed, shooter));
        ammo -= 1;
        return bullets;
    }

    @Override
    protected boolean hasAmmo() {
        return ammo > 1;
    }
}