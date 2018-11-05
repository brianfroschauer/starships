package edu.austral.starship.base.util.keyMap;

import edu.austral.starship.base.controller.command.*;

import java.awt.event.KeyEvent;

/**
 * Author: brianfroschauer
 * Date: 28/10/2018
 */
public class KeyMap1 {

    public KeyMap getKeyMap() {
        final KeyMap keyMap = new KeyMap();
        keyMap.put(KeyEvent.VK_UP, new MoveUp());
        keyMap.put(KeyEvent.VK_DOWN, new MoveDown());
        keyMap.put(KeyEvent.VK_LEFT, new MoveLeft());
        keyMap.put(KeyEvent.VK_RIGHT, new MoveRight());
        keyMap.put(KeyEvent.VK_SPACE, new Shoot());
        keyMap.put(KeyEvent.VK_SHIFT, new ChangeWeapon());
        return keyMap;
    }
}
