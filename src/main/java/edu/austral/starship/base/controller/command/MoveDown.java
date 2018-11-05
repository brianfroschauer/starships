package edu.austral.starship.base.controller.command;

import edu.austral.starship.base.model.entity.Player;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public class MoveDown implements Command {

    @Override
    public void execute(Player player) {
        player.moveDown();
    }
}