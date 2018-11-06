package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.Player;
import edu.austral.starship.base.model.entity.Starship;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Author: brianfroschauer
 * Date: 31/10/2018
 */
public class StarshipView extends View<Starship> {

    private final Player player;

    StarshipView(Player player, PImage image) {
        super(player.getStarship(), image);
        this.player = player;
    }

    @Override
    public void getRelativeDraw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.text(player.getName() + ": " + player.getScore(),
                getEntity().getPosition().x() - 25,
                getEntity().getPosition().y() + 40);

        graphics.text("Life " + getEntity().getLife(),
                getEntity().getPosition().x() - 25,
                getEntity().getPosition().y() + 55);
        graphics.popMatrix();
    }
}