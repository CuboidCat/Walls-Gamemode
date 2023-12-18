package com.cuboidcat.walls.teams;

import com.cuboidcat.walls.Main;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class teamListener implements Listener {
    private Main main;
    public teamListener (Main main) {
        this.main = main;
    }
    @EventHandler
    public void onjoin(PlayerJoinEvent e) {
        teamTablist.setTeams(e.getPlayer());

        Player player = e.getPlayer();
        ArrayList<String> Red = new ArrayList<>();
        ArrayList<String> Blue = new ArrayList<>();
        ArrayList<String> Green = new ArrayList<>();
        ArrayList<String> Purple = new ArrayList<>();
        ArrayList<String> Spectator = new ArrayList<>();

        teamTablist.setTeams(e.getPlayer());
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
        Spectator = (ArrayList<String>) modifyFile.getStringList("TeamsData.Spectator");
        //Check if player is already in team
        String inTeam = "";
        int index = 0;
        for (int i = 0; i < Red.size(); i++) {
            if (Red.get(i).equals(player.getUniqueId().toString())) {

                inTeam = "red";
            }
        }
        for (int i = 0; i < Blue.size(); i++) {
            if (Blue.get(i).equals(player.getUniqueId().toString())) {

                inTeam = "blue";
            }
        }
        for (int i = 0; i < Green.size(); i++) {
            if (Green.get(i).equals(player.getUniqueId().toString())) {

                inTeam = "green";
            }
        }
        for (int i = 0; i < Purple.size(); i++) {
            if (Purple.get(i).equals(player.getUniqueId().toString())) {

                inTeam = "purple";
            }
        }
        for (int i = 0; i < Spectator.size(); i++) {
            if (Spectator.get(i).equals(player.getUniqueId().toString())) {

                inTeam = "spec";
            }
        }

        if (!inTeam.equals("")) {
            switch (inTeam) {
                case "red":
                    new TeamStore(player.getUniqueId(), "red", main);
                    teamTablist.newTeam(player ,"red");
                    break;
                case "blue":
                    new TeamStore(player.getUniqueId(), "blue", main);
                    teamTablist.newTeam(player ,"blue");
                    break;
                case "green":
                    new TeamStore(player.getUniqueId(), "green", main);
                    teamTablist.newTeam(player ,"green");
                    break;
                case "purple":
                    new TeamStore(player.getUniqueId(), "purple", main);
                    teamTablist.newTeam(player ,"purple");
                    break;
                case "spec":
                    new TeamStore(player.getUniqueId(), "spec", main);
                    teamTablist.newTeam(player ,"spec");
                    break;
                default:
                    break;
            }
        }

        new joinEventUpdate(main);

    }


    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        teamTablist.clearTeam(e.getPlayer());
    }
}
