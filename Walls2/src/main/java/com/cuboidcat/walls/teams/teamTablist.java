package com.cuboidcat.walls.teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class teamTablist {
    public teamTablist(Player player, String Rank) {
        newTeam(player, Rank);
    }


    public static void setTeams(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        for (Teams team: Teams.values()) {
            Team t = player.getScoreboard().registerNewTeam(team.name());
            t.setPrefix(ChatColor.translateAlternateColorCodes('&', team.getDisplay()));
        }
    }

    public static void newTeam(Player player, String Rank) {
        Rank.toLowerCase();
        Boolean valid = false;
        Teams teams = null;
        switch (Rank) {
            case "red":
                teams = Teams.RED;
                valid = true;
                break;
            case "blue":
                teams = Teams.BLUE;
                valid = true;
                break;
            case "green":
                teams = Teams.GREEN;
                valid = true;
                break;
            case "purple":
                teams = Teams.PURPLE;
                valid = true;
                break;
            case "spec":
                teams = Teams.SPECTATOR;
                valid = true;
                break;

            default:
        }

        if (valid) {
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.getScoreboard().getTeam(teams.name()).addEntry(player.getName());
            }

        }


    }
    public static void clearTeam(Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.getScoreboard().getEntryTeam(player.getName()).removeEntry(player.getName());
        }

    }
}
