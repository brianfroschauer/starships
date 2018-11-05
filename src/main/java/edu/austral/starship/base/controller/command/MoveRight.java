package edu.austral.starship.base.controller.command;

import edu.austral.starship.base.model.entity.Player;

public class MoveRight implements Command {

    @Override
    public void execute(Player player) {
        player.moveRight();
    }
}