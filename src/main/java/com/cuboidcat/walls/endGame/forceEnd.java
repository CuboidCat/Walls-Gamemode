package com.cuboidcat.walls.endGame;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.wcmd.wallsCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class forceEnd implements CommandExecutor {
    Main main;
    public forceEnd(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (wallsCommand.getEnabled()) {
            if (!main.getDataFolder().exists()) {
                main.getDataFolder().mkdir();
            }
            File file = new File(main.getDataFolder(), "Alive.yml");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
        return false;
    }
}
