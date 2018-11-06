package edu.austral.starship.base.model.entity;

import java.util.List;
import java.util.Optional;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public abstract class Weapon {

    int ammo;

    Weapon() {
        ammo = 100;
    }

    Optional<List<Bullet>> shoot(Player player) {
        if (hasAmmo()) return Optional.of(relativeShoot(player));
        return Optional.empty();
    }

    abstract List<Bullet> relativeShoot(Player player);

    abstract boolean hasAmmo();

    void reload(int ammo) {
        this.ammo += ammo;
    }
}