package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.Ammo;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 03/11/2018
 */
class AmmoView extends View<Ammo> {

    AmmoView(Ammo entity, PImage image) {
        super(entity, image);
    }

    @Override
    void getRelativeDraw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.text("Ammo",
                getEntity().getPosition().x() - 25,
                getEntity().getPosition().y() + 50);
        graphics.popMatrix();
    }
}
