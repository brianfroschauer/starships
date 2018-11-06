package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.model.observable.Observable;
import edu.austral.starship.base.model.observable.Observer;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.vector.Vector2;
import edu.austral.starship.base.model.visitor.Visitor;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public class Starship extends Entity<Starship> implements Observable, Harmful {

    private final List<Observer> observers;
    private final Queue<Weapon> weapons;
    private int life;

    public Starship(Vector2 position, Vector2 direction, float speed, int life, Queue<Weapon> weapons) {
        super(position, direction, speed);
        this.observers = new ArrayList<>();
        this.weapons = weapons;
        this.life = life;
    }

    public Weapon getWeapon() {
        return weapons.peek();
    }

    public int getLife() {
        return life;
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

    void changeWeapon() {
        weapons.add(weapons.poll());
    }

    void shoot(Shooter shooter) {
        if (!weapons.isEmpty()) {
            Optional<List<Bullet>> shoot = weapons.peek().shoot(shooter, this);
            shoot.ifPresent(this::notifyObservers);
        }
    }

    void move(Vector2 direction) {
        this.direction = direction;
        position = position.add(direction.multiply(speed));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(List<Bullet> bullets) {
        observers.forEach(observer -> observer.update(bullets));
    }
}