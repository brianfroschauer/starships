package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.Bullet;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 31/10/2018
 */
public class BulletView extends View<Bullet> {

    BulletView(Bullet bullet, PImage image) {
        super(bullet, image);
    }

    @Override
    public void getRelativeDraw(PGraphics graphics) {

    }
}
