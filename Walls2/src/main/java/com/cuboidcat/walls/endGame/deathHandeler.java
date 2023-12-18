package com.cuboidcat.walls.endGame;

import com.cuboidcat.walls.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class deathHandeler {
    Main main;
    public deathHandeler(UUID e, Main main) throws IOException {
        this.main = main;
        if (!main.getDataFolder().exists()) {
            main.getDataFolder().mkdir(); }
        File file = new File(main.getDataFolder(), "Alive.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException ex) {
                System.out.println("Cant load file");
                return;
            }
        }
        YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
        ArrayList<String> Red = (ArrayList<String>) modifyFile.getStringList("Alive.Red");
        ArrayList<String> Blue = (ArrayList<String>) modifyFile.getStringList("Alive.Blue");
        ArrayList<String> Green = (ArrayList<String>) modifyFile.getStringList("Alive.Green");
        ArrayList<String> Purple = (ArrayList<String>) modifyFile.getStringList("Alive.Purple");
        ArrayList<String> RedDead = (ArrayList<String>) modifyFile.getStringList("Dead.Red");
        ArrayList<String> BlueDead = (ArrayList<String>) modifyFile.getStringList("Dead.Blue");
        ArrayList<String> GreenDead = (ArrayList<String>) modifyFile.getStringList("Dead.Green");
        ArrayList<String> PurpleDead = (ArrayList<String>) modifyFile.getStringList("Dead.Purple");
        //Check if player is already in team
        String inTeam = "";
        int index = 0;
        for (int i = 0; i < Red.size(); i++) {
            if (Red.get(i).equals(e.toString())) {
                index = i;
                inTeam = "red";
            }
        }
        for (int i = 0; i < Blue.size(); i++) {
            if (Blue.get(i).equals(e.toString())) {
                index = i;
                inTeam = "blue";
            }
        }
        for (int i = 0; i < Green.size(); i++) {
            if (Green.get(i).equals(e.toString())) {
                index = i;
                inTeam = "green";
            }
        }
        for (int i = 0; i < Purple.size(); i++) {
            if (Purple.get(i).equals(e.toString())) {
                index = i;
                inTeam = "purple";
            }
        }

        if (!inTeam.equals("")) {
            switch (inTeam) {
                case "red":
                    Red.remove(index);
                    RedDead.add(e.toString());
                    break;
                case "blue":
                    Blue.remove(index);
                    BlueDead.add(e.toString());
                    break;
                case "green":
                    Green.remove(index);
                    GreenDead.add(e.toString());
                    break;
                case "purple":
                    Purple.remove(index);
                    PurpleDead.add(e.toString());
                    break;
                default:
                    break;
            }


        }
        modifyFile.set("Alive.Red", Red);
        modifyFile.set("Alive.Blue", Blue);
        modifyFile.set("Alive.Green", Green);
        modifyFile.set("Alive.Purple", Purple);
        modifyFile.set("Dead.Red", RedDead);
        modifyFile.set("Dead.Blue", BlueDead);
        modifyFile.set("Dead.Green", GreenDead);
        modifyFile.set("Dead.Purple", PurpleDead);
        modifyFile.save(file);
    }
}
