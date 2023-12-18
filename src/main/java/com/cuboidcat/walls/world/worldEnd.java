package com.cuboidcat.walls.world;

import com.cuboidcat.walls.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class worldEnd {
    public worldEnd() {
        for (Player e : Bukkit.getOnlinePlayers()) {
            Location loc = new Location(Bukkit.getWorld("world"), 8, 110, 45);
            e.teleport(loc);
            e.setMaxHealth(20);
        }

        Bukkit.unloadWorld("walls",false);
        World world = Bukkit.createWorld(new WorldCreator("walls"));
        world.setAutoSave(false);
    }
}
