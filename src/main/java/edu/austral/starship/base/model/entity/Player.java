package edu.austral.starship.base.model.entity;

import edu.austral.starship.base.controller.command.KeyMap;
import edu.austral.starship.base.util.vector.Vector2;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public class Player implements Shooter {

    private final String name;
    private final Starship starship;
    private final KeyMap keyMap;
    private int score;

    public Player(String name, Starship starship, KeyMap keyMap) {
        this.name = name;
        this.starship = starship;
        this.keyMap = keyMap;
        this. score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public Starship getStarship() {
        return starship;
    }

    public KeyMap getKeyMap() {
        return keyMap;
    }

    public void shoot() {
        starship.shoot(this);
    }

    public void changeWeapon() {
        starship.changeWeapon();
    }

    public void moveUp() {
        starship.move(new Vector2(0, -1));
    }

    public void moveDown() {
        starship.move(new Vector2(0, 1));
    }

    public void moveLeft() {
        starship.move(new Vector2(-1, 0));
    }

    public void moveRight() {
        starship.move(new Vector2(1, 0));
    }
}