package com.cuboidcat.walls.teams;

public enum Teams {
    RED("&cRED ", 52,92,-5),
    PURPLE("&dPURPLE ",45, 94, -154),
    GREEN("&aGREEN ",149,68,-141),
    BLUE("&bBLUE ",163,75,2),
    SPECTATOR("&8Spectator ",87,196,-91);
    private String display;
    private int x;
    private int y;
    private int z;

    Teams(String display, int x, int y, int z) {
        this.display = display;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getDisplay(){
        return display;
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
