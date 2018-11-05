package edu.austral.starship.base.util.keyMap;

import edu.austral.starship.base.controller.command.*;

import java.awt.event.KeyEvent;

/**
 * Author: brianfroschauer
 * Date: 03/11/2018
 */
public class KeyMap3 {

    public KeyMap getKeyMap() {
        final KeyMap keyMap = new KeyMap();
        keyMap.put(KeyEvent.VK_W, new MoveUp());
        keyMap.put(KeyEvent.VK_S, new MoveDown());
        keyMap.put(KeyEvent.VK_A, new MoveLeft());
        keyMap.put(KeyEvent.VK_D, new MoveRight());
        keyMap.put(KeyEvent.VK_F, new Shoot());
        keyMap.put(KeyEvent.VK_R, new ChangeWeapon());
        return keyMap;
    }
}
