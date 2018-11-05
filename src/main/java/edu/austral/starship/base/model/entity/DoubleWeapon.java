package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 29/10/2018
 */
public class DoubleWeapon extends Weapon {

    @Override
    List<Bullet> relativeShoot(Shooter shooter, Starship starship) {
        final List<Bullet> bullets = new ArrayList<>();
        final Vector2 direction = starship.getDirection();
        final Vector2 position1 = starship.position.add(starship.direction.rotate(-100).multiply(50f));
        final Vector2 position2 = starship.position.add(starship.direction.rotate(100).multiply(50f));
        final float speed = 0.1f;
        bullets.add(new Bullet(position1, direction, speed, shooter));
        bullets.add(new Bullet(position2, direction, speed, shooter));
        ammo -= 2;
        return bullets;
    }

    @Override
    protected boolean hasAmmo() {
        return ammo > 1;
    }
}