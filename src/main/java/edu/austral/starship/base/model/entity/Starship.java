package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.model.observable.Observable;
import edu.austral.starship.base.model.observable.Observer;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;
import edu.austral.starship.base.model.visitor.Visitor;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Optional;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public class Starship extends Entity implements Observable, Harmful {

    private Observer observer;
    private Weapon weapon;
    private int life;

    public Starship(Vector2 position, Vector2 direction, float speed, int life) {
        super(position, direction, speed);
        this.weapon = new SingleWeapon();
        this.life = life;
    }

    @Override
    protected Shape getRelativeShape() {
        return new Rectangle2D.Float(position.x(), position.y(),
                Constants.STARSHIP_WIDTH, Constants.STARSHIP_HEIGHT);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        life -= starship.getDamage();
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {
        life -= asteroid.getDamage();
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {
        life -= bullet.getDamage();
    }

    @Override
    public void collisionedWithWeaponUpgrade(WeaponUpgrade weaponUpgrade) {

    }

    @Override
    public void update(float timeSinceLastDraw) {
        final float distance = timeSinceLastDraw * Constants.GRAVITY;
        position = position.add(direction.multiply(distance));
        checkBounds();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitStarship(this);
    }

    @Override
    public int getDamage() {
        return Constants.STARSHIP_DAMAGE;
    }

    @Override
    public boolean isDead() {
        return life <= 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void shoot(Player player) {
        final Optional<List<Bullet>> shoots = weapon.shoot(player);
        shoots.ifPresent(this::notifyObservers);
    }

    public void accelerate() {
        position = position.add(direction.multiply(speed));
    }

    public void rotate(float angle) {
        direction = direction.rotate(angle);
    }

    @Override
    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObservers(List<Bullet> bullets) {
        observer.update(bullets);
    }
}