package com.cuboidcat.walls.barrier;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Objects;
import java.util.concurrent.SynchronousQueue;

public class  deleteWalls {

    public deleteWalls(){

        Barrier barrier = null;
        for (int i = Barrier.WALL1BOTTOM.gety(); i <= Barrier.WALL1TOP.gety(); i++) {
            for (int j = Barrier.WALL1TOP.getz(); j <= Barrier.WALL1BOTTOM.getX(); j++){
                Location loc = new Location(Bukkit.getWorld("walls"),87,(double)i,(double)j);
                Location loc2 = new Location(Bukkit.getWorld("walls"),86,(double)i,(double)j);
                Block block = Objects.requireNonNull(Bukkit.getWorld("walls")).getBlockAt(loc);
                Block block2 = Objects.requireNonNull(Bukkit.getWorld("walls")).getBlockAt(loc2);
                if (block2.getType().equals(Material.DIRT) || block2.getType().equals(Material.GRASS_BLOCK)) {
                    block.setType(Material.DIRT);
                }
                else if (block2.getType().equals(Material.STONE)
                        || block2.getType().equals(Material.DIORITE)
                        || block2.getType().equals(Material.ANDESITE)
                        || block2.getType().equals(Material.GRANITE)
                        || block2.getType().equals(Material.COAL_ORE)
                        || block2.getType().equals(Material.IRON_ORE)
                        || block2.getType().equals(Material.DIAMOND_ORE)
                        || block2.getType().equals(Material.COPPER_ORE)
                        || block2.getType().equals(Material.GOLD_ORE)
                        || block2.getType().equals(Material.GRAVEL)) {
                    block.setType(Material.STONE);
                }
                else if (block2.getType().equals(Material.PACKED_ICE)
                        || block2.getType().equals(Material.ICE)) {
                    block.setType(Material.PACKED_ICE);
                }
                else if (block2.getType().equals(Material.SNOW_BLOCK)) {
                    block.setType(Material.SNOW_BLOCK);
                }
                else if (block2.getType().equals(Material.AIR)) {
                    block.setType(Material.AIR);
                }
                else if (block2.getType().equals(Material.GRAY_CONCRETE)
                        || block2.getType().equals(Material.SNOW)
                        || block2.getType().equals(Material.BARRIER)
                        || block2.getType().equals(Material.OAK_LEAVES)
                        || block2.getType().equals(Material.SPRUCE_LEAVES)
                        || block2.getType().equals(Material.BARRIER)
                        || block2.getType().equals(Material.BIRCH_LEAVES)) {
                    block.setType(Material.AIR);
                }
                else if (block2.getType().equals(Material.DEEPSLATE)) {
                    block.setType(Material.DEEPSLATE);
                }
                else {
                    block.setType(Material.STONE);
                }
            }
        }
        for (int i = Barrier.WALL2BOTTOM.gety(); i <= Barrier.WALL2TOP.gety(); i++) {
            for (int j = Barrier.WALL2BOTTOM.getX(); j <= Barrier.WALL2TOP.getX(); j++){

                Location loc = new Location(Bukkit.getWorld("walls"),(double) j,(double)i,-92);
                Location loc2 = new Location(Bukkit.getWorld("walls"),(double) j,(double)i,-93);
                Block block = Objects.requireNonNull(Bukkit.getWorld("walls")).getBlockAt(loc);
                Block block2 = Objects.requireNonNull(Bukkit.getWorld("walls")).getBlockAt(loc2);
                if (block2.getType().equals(Material.DIRT) || block2.getType().equals(Material.GRASS_BLOCK)) {
                    block.setType(Material.DIRT);
                }
                else if (block2.getType().equals(Material.STONE)
                        || block2.getType().equals(Material.DIORITE)
                        || block2.getType().equals(Material.ANDESITE)
                        || block2.getType().equals(Material.GRANITE)
                        || block2.getType().equals(Material.COAL_ORE)
                        || block2.getType().equals(Material.IRON_ORE)
                        || block2.getType().equals(Material.DIAMOND_ORE)
                        || block2.getType().equals(Material.COPPER_ORE)
                        || block2.getType().equals(Material.GOLD_ORE)
                        || block2.getType().equals(Material.GRAVEL)) {
                    block.setType(Material.STONE);
                }
                else if (block2.getType().equals(Material.PACKED_ICE)
                        || block2.getType().equals(Material.ICE)) {
                    block.setType(Material.PACKED_ICE);
                }
                else if (block2.getType().equals(Material.SNOW_BLOCK)) {
                    block.setType(Material.SNOW_BLOCK);
                }
                else if (block2.getType().equals(Material.AIR)) {
                    block.setType(Material.AIR);
                }
                else if (block2.getType().equals(Material.DEEPSLATE)) {
                    block.setType(Material.DEEPSLATE);
                }
                else if (block2.getType().equals(Material.GRAY_CONCRETE)
                         || block2.getType().equals(Material.SNOW)
                         || block2.getType().equals(Material.BARRIER)
                        || block2.getType().equals(Material.OAK_LEAVES)
                        || block2.getType().equals(Material.SPRUCE_LEAVES)
                        || block2.getType().equals(Material.BARRIER)
                        || block2.getType().equals(Material.BIRCH_LEAVES)) {
                    block.setType(Material.AIR);
                }
                else {
                    block.setType(Material.STONE);
                }
            }
        }
    }
}
