package edu.austral.starship.base.controller;

import edu.austral.starship.base.controller.command.Command;
import edu.austral.starship.base.model.GameModel;
import edu.austral.starship.base.model.entity.*;
import edu.austral.starship.base.model.factory.AmmoFactory;
import edu.austral.starship.base.model.factory.AsteroidFactory;
import edu.austral.starship.base.model.factory.StarshipFactory;
import edu.austral.starship.base.model.factory.WeaponUpgradeFactory;
import edu.austral.starship.base.model.observable.Observer;
import edu.austral.starship.base.util.keyMap.KeyMap1;
import edu.austral.starship.base.util.keyMap.KeyMap2;
import edu.austral.starship.base.framework.ImageLoader;

import edu.austral.starship.base.view.GameView;
import processing.core.PGraphics;

import java.util.*;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public class GameController implements Observer {

    private final GameModel gameModel;
    private final GameView gameView;
    private final Set<Player> players;

    public GameController() {
        gameModel = new GameModel();
        gameView = new GameView();
        players = new HashSet<>();
    }

    public void setup(ImageLoader imageLoader) {
        gameView.setup(imageLoader);
        setupAsteroids();
        setupPlayers();
    }

    public void draw(PGraphics graphics) {
        gameView.draw(graphics);
    }

    public void keyPressed(Set<Integer> keySet) {
        keySet.forEach(keyCode -> players.forEach(player -> {
            Optional<Command> commandOptional = player.getKeyMap().get(keyCode);
            commandOptional.ifPresent(command -> command.execute(player));
        }));
    }

    public void update(float timeSinceLastDraw) {
        gameModel.update(timeSinceLastDraw);
        removeDeadEntities();
        spawnWeaponUpgrade();
        spawnAmmo();
    }

    private void removeDeadEntities() {
        gameModel.removeDeadModels();
        gameView.removeDeadModels();
        players.removeIf(player -> player.getStarship().isDead());
    }

    private void setupAsteroids() {
        final List<Asteroid> asteroids = new AsteroidFactory().build(15);
        gameView.createAsteroid(asteroids);
        gameModel.addAll(asteroids);
    }

    private void setupPlayers() {
        final List<Starship> starships = new ArrayList<>();
        final List<Player> players = new ArrayList<>();

        final Starship starship1 = new StarshipFactory().build();
        final Starship starship2 = new StarshipFactory().build();
        final Player player1 = new Player("Player1", starship1, new KeyMap1().getKeyMap());
        final Player player2 = new Player("Player2", starship2, new KeyMap2().getKeyMap());

        starships.add(starship1);
        starships.add(starship2);
        players.add(player1);
        players.add(player2);

        starship1.addObserver(this);
        starship2.addObserver(this);

        gameModel.addAll(starships);
        gameView.createStarship(players);

        this.players.add(player1);
        this.players.add(player2);
    }

    private void spawnAmmo() {
        final AmmoFactory ammoFactory = new AmmoFactory();
        final int probability = new Random().nextInt(1000);
        if (probability < 3) {
            Ammo ammo = ammoFactory.build();
            gameModel.add(ammo);
            gameView.createAmmo(ammo);
        }
    }

    private void spawnWeaponUpgrade() {
        final int probability = new Random().nextInt(10000);
        if (probability < 5) {
            WeaponUpgrade weaponUpgrade = new WeaponUpgradeFactory().build();
            gameModel.add(weaponUpgrade);
            gameView.createWeaponUpgrade(weaponUpgrade);
        }
    }

    @Override
    public void update(List<Bullet> bullets) {
        gameModel.addAll(bullets);
        gameView.createBullet(bullets);
    }
}