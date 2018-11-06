package edu.austral.starship.base.model.visitor;

import edu.austral.starship.base.model.entity.Asteroid;
import edu.austral.starship.base.model.entity.Bullet;
import edu.austral.starship.base.model.entity.Starship;
import edu.austral.starship.base.model.entity.WeaponUpgrade;

/**
 * Author: brianfroschauer
 * Date: 26/10/2018
 */
public interface Visitor {

    void visitStarship(Starship starship);
    void visitAsteroid(Asteroid asteroid);
    void visitBullet(Bullet bullet);
    void visitWeaponUpgrade(WeaponUpgrade weaponUpgrade);
}
