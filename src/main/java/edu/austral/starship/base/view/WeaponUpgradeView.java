package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.WeaponUpgrade;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 06/11/2018
 */
class WeaponUpgradeView extends View<WeaponUpgrade> {


    WeaponUpgradeView(WeaponUpgrade entity, PImage image) {
        super(entity, image);
    }

    @Override
    void getRelativeDraw(PGraphics graphics) {

    }
}
