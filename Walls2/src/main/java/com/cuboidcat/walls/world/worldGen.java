package com.cuboidcat.walls.world;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class worldGen {
    public worldGen() {
        World world = Bukkit.createWorld(new WorldCreator("walls.world"));
        world.setAutoSave(false);

    }
}
