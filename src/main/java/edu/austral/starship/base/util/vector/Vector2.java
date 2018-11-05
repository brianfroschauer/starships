package edu.austral.starship.base.util.vector;

import static java.lang.Math.*;

public class Vector2 {

    private float x;
    private float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 multiply(Float scalar) {
        return new Vector2(x * scalar, y * scalar);
    }

    public Vector2 rotate(float angle) {
        return new Vector2((float) (x * cos(angle) - y * sin(angle)), (float) (x * sin(angle) + y * cos(angle)));
    }

    public float module() {
        return (float) Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
    }

    public Vector2 unitary() {
        final float module = module();
        return new Vector2(x / module, y / module);
    }

    public float angle() {
        return (float) (atan2(y, x) - atan2(0, 1));
    }
}
