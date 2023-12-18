package com.cuboidcat.walls.world;

import com.cuboidcat.walls.teams.TeamStore;
import com.cuboidcat.walls.teams.Teams;
import com.cuboidcat.walls.teams.teamTablist;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import com.cuboidcat.walls.Main;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class worldStart {

    private Main main;
    private ArrayList<String> Red = new ArrayList<>();
    private ArrayList<String> Blue = new ArrayList<>();
    private ArrayList<String> Green = new ArrayList<>();
    private ArrayList<String> Purple = new ArrayList<>();
    private ArrayList<Player> spec = new ArrayList<>();
    public worldStart(Main main) throws IOException {
        alive(main);
        spec.addAll(Bukkit.getOnlinePlayers());
        this.main = main;
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
        Location locr = new Location(Bukkit.getWorld("walls"), Teams.RED.getX(), Teams.RED.gety(), Teams.RED.getz());
        Location locb = new Location(Bukkit.getWorld("walls"), Teams.BLUE.getX(), Teams.BLUE.gety(), Teams.BLUE.getz());
        Location locg = new Location(Bukkit.getWorld("walls"), Teams.GREEN.getX(), Teams.GREEN.gety(), Teams.GREEN.getz());
        Location locp = new Location(Bukkit.getWorld("walls"), Teams.PURPLE.getX(), Teams.PURPLE.gety(), Teams.PURPLE.getz());

        for (String b : Red) {
            UUID id = UUID.fromString(b);
            if (Bukkit.getPlayer(id).isOnline()) {
            Bukkit.getPlayer(id).teleport(locr);}
            Boolean online = false;
            Player temp = null;
            for (Player player: spec) {
                if (Bukkit.getPlayer(id).equals(player)) {
                    online = true;
                    temp = Bukkit.getPlayer(id);
                }
            }
            if (online == true) {
                spec.remove(temp);
            }}
        for (String b : Blue) {
            UUID id = UUID.fromString(b);
            if (Bukkit.getPlayer(id).isOnline()) {
            Bukkit.getPlayer(id).teleport(locb);}
            Boolean online = false;
            Player temp = null;
            for (Player player: spec) {
                if (Bukkit.getPlayer(id).equals(player)) {
                    online = true;
                    temp = Bukkit.getPlayer(id);
                }
            }
            if (online == true) {
                spec.remove(temp);
            }}
        for (String b : Green) {
            UUID id = UUID.fromString(b);
            if (Bukkit.getPlayer(id).isOnline()) {
            Bukkit.getPlayer(id).teleport(locg);}
            boolean online = false;
            Player temp = null;
            for (Player player: spec) {
                if (Bukkit.getPlayer(id).equals(player)) {
                    online = true;
                    temp = Bukkit.getPlayer(id);
                }
            }
            if (online) {
                spec.remove(temp);
            }}
        for (String b : Purple) {
            UUID id = UUID.fromString(b);
            if (Bukkit.getPlayer(id).isOnline()) {
            Bukkit.getPlayer(id).teleport(locp);}
            boolean online = false;
            Player temp = null;
            for (Player player: spec) {
                if (Bukkit.getPlayer(id).equals(player)) {
                    online = true;
                    temp = Bukkit.getPlayer(id);
                }
            }
            if (online) {
                spec.remove(temp);
            }}

        for (Player player : spec) {
            new TeamStore(player.getUniqueId(), "spec", main);
            player.teleport(new Location(Bukkit.getWorld("walls"), Teams.SPECTATOR.getX(), Teams.SPECTATOR.gety(), Teams.SPECTATOR.getz()));
            new teamTablist(player, "spec");
            player.setGameMode(GameMode.SPECTATOR);
        }





    }


    public void alive(Main main) throws IOException {
        this.main = main;
        ArrayList<String> Red = new ArrayList<>();
        ArrayList<String> Blue = new ArrayList<>();
        ArrayList<String> Green = new ArrayList<>();
        ArrayList<String> Purple = new ArrayList<>();
        if (!main.getDataFolder().exists()) {
            main.getDataFolder().mkdir();
        }
        File file = new File(main.getDataFolder(), "Alive.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cant load file");
                return;
            }
        }
        File file2 = new File(main.getDataFolder(), "TeamsData.yml");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException ex) {
                System.out.println("Cant load file");
                return;
            }
        }
            YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
            YamlConfiguration modifyFile2 = YamlConfiguration.loadConfiguration(file2);
            Red = (ArrayList<String>) modifyFile2.getStringList("TeamsData.Red");
            Blue = (ArrayList<String>) modifyFile2.getStringList("TeamsData.Blue");
            Green = (ArrayList<String>) modifyFile2.getStringList("TeamsData.Green");
            Purple = (ArrayList<String>) modifyFile2.getStringList("TeamsData.Purple");
            modifyFile.set("Alive.Red", Red);
            modifyFile.set("Alive.Blue", Blue);
            modifyFile.set("Alive.Green", Green);
            modifyFile.set("Alive.Purple", Purple);
            modifyFile.set("Dead.Red", new ArrayList<>());
            modifyFile.set("Dead.Blue", new ArrayList<>());
            modifyFile.set("Dead.Green", new ArrayList<>());
            modifyFile.set("Dead.Purple", new ArrayList<>());


                modifyFile.save(file);
}
}
