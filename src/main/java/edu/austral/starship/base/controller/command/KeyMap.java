package edu.austral.starship.base.controller.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Author: brianfroschauer
 * Date: 25/10/2018
 */
public class KeyMap {

    private final Map<Integer, Command> commands;

    public KeyMap() {
        commands = new HashMap<>();
    }

    public void put(Integer keyEvent, Command command) {
        commands.put(keyEvent, command);
    }

    public Optional<Command> get(Integer keyCode) {
        return Optional.ofNullable(commands.get(keyCode));
    }
}