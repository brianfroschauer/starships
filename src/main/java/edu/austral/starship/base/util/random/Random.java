package edu.austral.starship.base.util.random;

import edu.austral.starship.base.util.vector.Vector2;

/**
 * Author: brianfroschauer
 * Date: 27/10/2018
 */
public class Random {

    private Random() {}

    /**
     * Generates a random {@link Vector2}
     *
     * @param x1 lower x coordinate bound
     * @param x2 upper x coordinate bound
     * @param y1 lower y coordinate bound
     * @param y2 upper y coordinate bound
     * @return a new pseudorandom Vector2
     */
    public static Vector2 getVector(int x1, int x2, int y1, int y2) {
        final float x = new java.util.Random().nextInt(x2 - x1) + x1;
        final float y = new java.util.Random().nextInt(y2 - y1) + y1;
        return new Vector2(x, y);
    }

    /**
     * Generates a random between two values
     *
     * @param lower bound
     * @param upper bound
     * @return a new pseudorandom int
     */
    public static int nextInt(int lower, int upper) {
        return new java.util.Random().nextInt(upper - lower) + lower;
    }

    public static float nextFloat() {
        return new java.util.Random().nextFloat();
    }
}