package com.cuboidcat.walls.teams;

import com.cuboidcat.walls.Main;
import net.kyori.adventure.util.Index;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class TeamStore {
    private static ArrayList<String>  Red = new ArrayList<>();
    private static ArrayList<String>  Blue = new ArrayList<>();
    private static ArrayList<String>  Green = new ArrayList<>();
    private static ArrayList<String>  Purple = new ArrayList<>();
    private static ArrayList<String>  Spec = new ArrayList<>();

    public TeamStore(UUID e, String team, Main main) {

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
        Spec = (ArrayList<String>) modifyFile.getStringList("TeamsData.Spectator");
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
        for (int i = 0; i < Spec.size(); i++) {
            if (Spec.get(i).equals(e.toString())) {
                index = i;
                inTeam = "spec";
            }
        }

        if (!inTeam.equals("")) {
            switch (inTeam) {
                case "red":
                    Red.remove(index);
                    break;
                case "blue":
                    Blue.remove(index);
                    break;
                case "green":
                    Green.remove(index);
                    break;
                case "purple":
                    Purple.remove(index);
                    break;
                case "spec":
                    Spec.remove(index);
                    break;
                default:
                    break;
            }
        }








        //set team in yml

        team.toLowerCase();
        switch (team) {
            case "red":
                Red.add(e.toString());
                break;
            case "blue":
                Blue.add(e.toString());
                break;
            case "green":
                Green.add(e.toString());
                break;
            case "purple":
                Purple.add(e.toString());
                break;
            case "spec":
                Spec.add(e.toString());
                break;
            default:
                break;
        }
        modifyFile.set("TeamsData.Red", Red);
        modifyFile.set("TeamsData.Blue", Blue);
        modifyFile.set("TeamsData.Green", Green);
        modifyFile.set("TeamsData.Purple", Purple);
        modifyFile.set("TeamsData.Spectator", Spec);
        try {
            modifyFile.save(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public ArrayList<String> getRed() {
        return Red;
    }
    public ArrayList<String> getBlue() {
        return Blue;
    }
    public ArrayList<String> getGreen() {
        return Green;
    }
    public ArrayList<String> getPurple() {
        return Purple;
    }
    public ArrayList<String> getSpec() {
        return Spec;
    }
}
