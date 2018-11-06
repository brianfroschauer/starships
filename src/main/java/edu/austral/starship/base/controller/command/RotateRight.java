package edu.austral.starship.base.controller.command;

import edu.austral.starship.base.model.entity.Player;

/**
 * Author: brianfroschauer
 * Date: 05/11/2018
 */
public class RotateRight implements Command {

    @Override
    public void execute(Player player) {
        player.rotateRight();
    }
}