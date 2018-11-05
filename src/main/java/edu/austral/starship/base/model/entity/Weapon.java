package edu.austral.starship.base.model.entity;

import java.util.List;
import java.util.Optional;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public abstract class Weapon {

    int ammo = 100;

    Optional<List<Bullet>> shoot(Shooter shooter, Starship starship) {
        if (hasAmmo()) {
            List<Bullet> bullets = relativeShoot(shooter, starship);
            return Optional.ofNullable(bullets);
        }
        return Optional.empty();
    }

    abstract List<Bullet> relativeShoot(Shooter shooter, Starship starship);

    abstract boolean hasAmmo();

    void reload(int ammo) {
        this.ammo += ammo;
    }
}