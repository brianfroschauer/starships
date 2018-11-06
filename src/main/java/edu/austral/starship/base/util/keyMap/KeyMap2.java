package edu.austral.starship.base.util.keyMap;

import edu.austral.starship.base.controller.command.*;

import java.awt.event.KeyEvent;

/**
 * Author: brianfroschauer
 * Date: 28/10/2018
 */
public class KeyMap2 {

    public KeyMap getKeyMap() {
        final KeyMap keyMap = new KeyMap();
        keyMap.put(KeyEvent.VK_2, new Accelerate());
        keyMap.put(KeyEvent.VK_1, new RotateLeft());
        keyMap.put(KeyEvent.VK_3, new RotateRight());
        keyMap.put(KeyEvent.VK_4, new Shoot());
        keyMap.put(KeyEvent.VK_E, new ChangeWeapon());
        return keyMap;
    }
}