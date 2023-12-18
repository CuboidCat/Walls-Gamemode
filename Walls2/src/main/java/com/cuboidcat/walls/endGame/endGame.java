package com.cuboidcat.walls.endGame;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.endTimer;
import com.cuboidcat.walls.wcmd.wallsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class endGame {
    Main main;
    public endGame(String winner, Main main) {
        this.main = main;
        Announce(winner);
        }
    private void Announce(String winner) {
        wallsCommand.disable();
        new endTimer(30, main);
        for (Player a: Bukkit.getOnlinePlayers()) {
            a.getWorld().playSound(a, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            a.sendTitle("", ChatColor.GREEN + "Team" +" "+ winner +" " + "have won the game!",0,60,20);
            a.sendMessage(ChatColor.RED + "Game will end in 30 seconds.");
        }
    }
}



