package edu.austral.starship.base.model.visitor;

/**
 * Author: brianfroschauer
 * Date: 26/10/2018
 */
public interface Visitable {

    void accept(Visitor visitor);
}
