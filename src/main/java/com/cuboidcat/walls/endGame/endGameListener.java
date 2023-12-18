package com.cuboidcat.walls.endGame;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.teams.teamTablist;
import com.cuboidcat.walls.wcmd.wallsCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class endGameListener implements Listener {
    Main main;


    public endGameListener(Main main) {
        this.main = main;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) throws IOException {
        new deathHandeler(e.getPlayer().getUniqueId(), main);
        if (wallsCommand.getEnabled()) {
            if (!main.getDataFolder().exists()) {
                main.getDataFolder().mkdir();
            }
            File file = new File(main.getDataFolder(), "Alive.yml");
            if (!file.exists()) {
                    file.createNewFile();
            }

            YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
            ArrayList<String> Red = (ArrayList<String>) modifyFile.getStringList("Alive.Red");
            ArrayList<String> Blue = (ArrayList<String>) modifyFile.getStringList("Alive.Blue");
            ArrayList<String> Green = (ArrayList<String>) modifyFile.getStringList("Alive.Green");
            ArrayList<String> Purple = (ArrayList<String>) modifyFile.getStringList("Alive.Purple");

            if (Red.size() > 0 && Blue.size() == 0 && Green.size() == 0 && Purple.size() == 0) {
                new endGame("red",main);
            }
            else if (Red.size() == 0 && Blue.size() > 0 && Green.size() == 0 && Purple.size() == 0) {
                new endGame("Blue",main);
            }
            else if (Red.size() == 0 && Blue.size() == 0 && Green.size() > 0 && Purple.size() == 0) {
                new endGame("Green",main);
            }
            else if (Red.size() == 0 && Blue.size() == 0 && Green.size() == 0 && Purple.size() > 0) {
                new endGame("Purple",main);
            }

        }
    }
}
