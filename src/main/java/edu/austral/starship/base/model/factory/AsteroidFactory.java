package edu.austral.starship.base.model.factory;

import edu.austral.starship.base.model.entity.Asteroid;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.random.Random;
import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 28/10/2018
 */
public class AsteroidFactory implements Factory<Asteroid> {

    @Override
    public List<Asteroid> build(int amount) {
        final List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < amount; i++) asteroids.add(build());
        return asteroids;
    }

    @Override
    public Asteroid build() {
        final Vector2 position = Random.getVector(0, Constants.GAME_WIDTH, 0, Constants.GAME_HEIGHT / 2);
        final Vector2 direction = new Vector2(Random.nextFloat(), Random.nextFloat()).unitary();
        final float speed = 0f;
        final int life = Random.nextInt(300, 800);
        return new Asteroid(position, direction, speed, life);
    }
}