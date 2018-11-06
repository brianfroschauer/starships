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
        keyMap.put(KeyEvent.VK_W, new Accelerate());
        keyMap.put(KeyEvent.VK_A, new RotateLeft());
        keyMap.put(KeyEvent.VK_D, new RotateRight());
        keyMap.put(KeyEvent.VK_F, new Shoot());
        return keyMap;
    }
}