package edu.austral.starship.base.model;

import edu.austral.starship.base.model.entity.Entity;
import edu.austral.starship.base.collision.CollisionEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 01/11/2018
 */
public class GameModel {

    private final List<Entity> entities;
    private final CollisionEngine<Entity> collisionEngine;

    public GameModel() {
        this.entities = new ArrayList<>();
        this.collisionEngine = new CollisionEngine<>();
    }

    public void update(float timeSinceLastDraw) {
        entities.forEach(entity -> entity.update(timeSinceLastDraw));
        collisionEngine.checkCollisions(entities);
}

    public void addAll(List<? extends Entity> entities) {
        this.entities.addAll(entities);
    }

    public void add(Entity entity) {
        this.entities.add(entity);
    }

    public void removeDeadModels() {
        entities.removeIf(Entity::isDead);
    }
}