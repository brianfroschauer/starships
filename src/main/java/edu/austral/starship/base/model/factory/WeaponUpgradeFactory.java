package edu.austral.starship.base.model.factory;

import edu.austral.starship.base.model.entity.WeaponUpgrade;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.util.random.Random;
import edu.austral.starship.base.util.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 06/11/2018
 */
public class WeaponUpgradeFactory implements Factory<WeaponUpgrade> {

    @Override
    public List<WeaponUpgrade> build(int amount) {
        final List<WeaponUpgrade> weaponUpgrades = new ArrayList<>();
        for (int i = 0; i < amount; i++) weaponUpgrades.add(build());
        return weaponUpgrades;
    }

    @Override
    public WeaponUpgrade build() {
        final Vector2 position = Random.getVector(0, Constants.GAME_WIDTH, 0, Constants.GAME_HEIGHT);
        final Vector2 direction = new Vector2(Random.nextFloat(), Random.nextFloat()).unitary();
        final float speed = 0f;
        return new WeaponUpgrade(position, direction, speed);
    }
}