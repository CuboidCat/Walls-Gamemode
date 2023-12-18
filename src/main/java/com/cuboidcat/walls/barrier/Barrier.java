package com.cuboidcat.walls.barrier;

public enum Barrier {
    WALL1TOP(87, 194, -192),
    WALL1BOTTOM(87,-63,8),
    WALL2TOP(187,194,-92),
    WALL2BOTTOM(-14,-63,-92);

    private int x;
    private int y;
    private int z;

    Barrier(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getz(){
        return z;
    }
}

