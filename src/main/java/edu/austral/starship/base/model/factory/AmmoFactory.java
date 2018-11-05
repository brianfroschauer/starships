package edu.austral.starship.base.model.factory;

import edu.austral.starship.base.model.entity.Ammo;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.random.Random;
import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 03/11/2018
 */
public class AmmoFactory implements Factory<Ammo> {

    @Override
    public List<Ammo> build(int amount) {
        final List<Ammo> ammo = new ArrayList<>();
        for (int i = 0; i < amount; i++) ammo.add(build());
        return ammo;
    }

    @Override
    public Ammo build() {
        final Vector2 position = Random.getVector(0, Constants.GAME_WIDTH, 0, Constants.GAME_HEIGHT);
        final Vector2 direction = new Vector2(Random.nextFloat(), Random.nextFloat()).unitary();
        final float speed = 0f;
        final int ammo = Random.nextInt(50, 200);
        return new Ammo(position, direction, speed, ammo);
    }
}
