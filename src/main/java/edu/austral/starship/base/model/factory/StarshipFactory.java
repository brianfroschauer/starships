package edu.austral.starship.base.model.factory;

import edu.austral.starship.base.model.entity.DoubleWeapon;
import edu.austral.starship.base.model.entity.SingleWeapon;
import edu.austral.starship.base.model.entity.Starship;

import edu.austral.starship.base.model.entity.Weapon;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.random.Random;
import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Author: brianfroschauer
 * Date: 28/10/2018
 */

public class StarshipFactory implements Factory<Starship> {

    @Override
    public List<Starship> build(int amount) {
        final List<Starship> starships = new ArrayList<>();
        for (int i = 0; i < amount; i++) starships.add(build());
        return starships;
    }

    @Override
    public Starship build() {
        final Vector2 position = Random.getVector(0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT / 2, Constants.GAME_HEIGHT);
        final Vector2 direction = new Vector2(0, -1);
        final float speed = 3f;
        final SingleWeapon singleWeapon = new SingleWeapon();
        final DoubleWeapon doubleWeapon = new DoubleWeapon();
        final Queue<Weapon> weapons = new ConcurrentLinkedQueue<>();
        weapons.add(singleWeapon);
        weapons.add(doubleWeapon);
        return new Starship(position, direction, speed, 500, weapons);
    }
}