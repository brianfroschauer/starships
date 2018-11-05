package edu.austral.starship.base.model.observable;

import edu.austral.starship.base.model.entity.Bullet;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 01/11/2018
 */
public interface Observer {

    void update(List<Bullet> bullets);
}
