package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.model.visitor.Visitor;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Author: brianfroschauer
 * Date: 06/11/2018
 */
public class WeaponUpgrade extends Entity {

    private boolean dead = false;

    public WeaponUpgrade(Vector2 position, Vector2 direction, float speed) {
        super(position, direction, speed);
    }

    @Override
    protected Shape getRelativeShape() {
        return new Rectangle2D.Float(position.x(), position.y(),
                Constants.WEAPON_UPGRADE_WIDTH, Constants.WEAPON_UPGRADE_HEIGHT);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        starship.setWeapon(new DoubleWeapon());
        dead = true;
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {

    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {

    }

    @Override
    public void collisionedWithWeaponUpgrade(WeaponUpgrade weaponUpgrade) {

    }

    @Override
    public void update(float timeSinceLastDraw) {
        final float distance = timeSinceLastDraw * (Constants.GRAVITY + speed);
        position = position.add(direction.multiply(distance));
        checkBounds();
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitWeaponUpgrade(this);
    }
}
