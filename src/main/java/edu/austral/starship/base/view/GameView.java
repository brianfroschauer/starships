package edu.austral.starship.base.view;

import edu.austral.starship.base.model.entity.*;
import edu.austral.starship.base.util.constants.Constants;
import edu.austral.starship.base.framework.ImageLoader;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 31/10/2018
 */
public class GameView {

    private final List<View> views;
    private PImage background;
    private PImage starshipImage;
    private PImage asteroidImage;
    private PImage bulletImage;
    private PImage ammoImage;

    public GameView() {
        views = new ArrayList<>();
    }

    public void setup(ImageLoader imageLoader) {
        background = imageLoader.load(Constants.BACKGROUND_IMAGE);
        starshipImage = imageLoader.load(Constants.STARSHIP_IMAGE);
        asteroidImage = imageLoader.load(Constants.ASTEROID_IMAGE);
        bulletImage = imageLoader.load(Constants.BULLET_IMAGE);
        ammoImage = imageLoader.load(Constants.AMMO_IMAGE);

        background.resize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        starshipImage.resize(Constants.STARSHIP_WIDTH, Constants.STARSHIP_HEIGHT);
        asteroidImage.resize(Constants.ASTEROID_WIDTH, Constants.ASTEROID_HEIGHT);
        bulletImage.resize(Constants.BULLET_WIDTH, Constants.BULLET_HEIGHT);
        ammoImage.resize(Constants.AMMO_WIDTH, Constants.AMMO_HEIGHT);
    }

    public void draw(PGraphics graphics) {
        graphics.background(background);
        views.forEach(view -> view.draw(graphics));
    }

    public void createStarship(List<Player> players) {
        players.forEach(player -> views.add(new StarshipView(player, starshipImage)));
    }

    public void createAsteroid(List<Asteroid> asteroids) {
        asteroids.forEach(asteroid -> views.add(new AsteroidView(asteroid, asteroidImage)));
    }

    public void createBullet(List<Bullet> bullets) {
        bullets.forEach(bullet -> views.add(new BulletView(bullet, bulletImage)));
    }

    public void createAmmo(Ammo ammo) {
        views.add(new AmmoView(ammo, ammoImage));
    }

    public void removeDeadModels() {
        final Iterator<View> iterator = views.iterator();
        while (iterator.hasNext()) {
            final Entity entity = iterator.next().getEntity();
            if (entity.isDead()) iterator.remove();
        }
    }
}