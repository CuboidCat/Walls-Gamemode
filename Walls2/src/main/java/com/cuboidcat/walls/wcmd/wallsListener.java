package com.cuboidcat.walls.wcmd;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.teams.TeamStore;
import com.cuboidcat.walls.teams.Teams;
import com.cuboidcat.walls.teams.teamTablist;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class wallsListener implements Listener {
    private Main main;
    public wallsListener(Main main) {
        this.main = main;
    }
    @EventHandler
    private void playerBreak(BlockBreakEvent e) {
        if (wallsCommand.getEnabled()) {
            Player player = (Player) e.getPlayer();
            if (main.getTimer() > 0) {
                if (e.getBlock().getType().equals(Material.GRAY_CONCRETE)) {
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED.toString() + "You cannot break this block");
                }
            }
        }
    }
    @EventHandler
    private void respawn2(PlayerDeathEvent e) {
        if (wallsCommand.getEnabled()) {
            Player player = e.getPlayer();
            new TeamStore(player.getUniqueId(), "spec", main);
            new teamTablist(player, "spec");
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

    @EventHandler
    private void respawn(PlayerRespawnEvent e) {
        if (wallsCommand.getEnabled()) {
            e.setRespawnLocation(new Location(Bukkit.getWorld("walls"), Teams.SPECTATOR.getX(), Teams.SPECTATOR.gety(), Teams.SPECTATOR.getz()));
    }}


    @EventHandler
    private void attack(EntityDamageByEntityEvent e) {
        if (wallsCommand.getEnabled()) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            Player attacker = (Player) e.getDamager();
            ArrayList<String> Red = new ArrayList<>();
            ArrayList<String> Blue = new ArrayList<>();
            ArrayList<String> Green = new ArrayList<>();
            ArrayList<String> Purple = new ArrayList<>();
            if (!main.getDataFolder().exists()) {
                main.getDataFolder().mkdir(); }
            File file = new File(main.getDataFolder(), "TeamsData.yml");
            if (!file.exists()) {
                try {
                    file.createNewFile();

                } catch (IOException ex) {
                    System.out.println("Cant load file");
                    return;
                }
            }
            YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);

            Red = (ArrayList<String>) modifyFile.getStringList("TeamsData.Red");
            Blue = (ArrayList<String>) modifyFile.getStringList("TeamsData.Blue");
            Green = (ArrayList<String>) modifyFile.getStringList("TeamsData.Green");
            Purple = (ArrayList<String>) modifyFile.getStringList("TeamsData.Purple");
            //Check if player is already in team
            String inTeamP = "";
            String inTeamA = "";
            int index = 0;
            for (int i = 0; i < Red.size(); i++) {
                if (Red.get(i).equals(player.getUniqueId().toString())) {
                    inTeamP = "red";
                }
                if (Red.get(i).equals(attacker.getUniqueId().toString())) {
                    inTeamA = "red";
                }
            }
            for (int i = 0; i < Blue.size(); i++) {
                if (Blue.get(i).equals(player.getUniqueId().toString())) {

                    inTeamP = "blue";
                }
                if (Blue.get(i).equals(attacker.getUniqueId().toString())) {
                    inTeamA = "blue";
                }
            }
            for (int i = 0; i < Green.size(); i++) {
                if (Green.get(i).equals(player.getUniqueId().toString())) {

                    inTeamP = "green";
                }
                if (Green.get(i).equals(attacker.getUniqueId().toString())) {
                    inTeamA = "green";
                }
            }
            for (int i = 0; i < Purple.size(); i++) {
                if (Purple.get(i).equals(player.getUniqueId().toString())) {

                    inTeamP = "purple";
                }
                if (Purple.get(i).equals(attacker.getUniqueId().toString())) {
                    inTeamA = "purple";
                }
            }

            if (inTeamP.equals(inTeamA)) {
                e.setCancelled(true);
            }

        }
    }
    }
}