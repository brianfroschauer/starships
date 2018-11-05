package edu.austral.starship.base.model.factory;

import edu.austral.starship.base.model.entity.Entity;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 28/10/2018
 */
public interface Factory<T extends Entity> {

    List<T> build(int amount);
    T build();
}