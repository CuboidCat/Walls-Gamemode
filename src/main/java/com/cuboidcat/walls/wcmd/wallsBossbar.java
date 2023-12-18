package com.cuboidcat.walls.wcmd;

import com.cuboidcat.walls.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.UUID;

public class wallsBossbar {

    private Main main;

    public wallsBossbar(Main main) {
        for (Player e: Bukkit.getOnlinePlayers()) {
            main.getBossBar().addPlayer(e);
        }
        this.main = main;
        int startTime = main.getTimer();
        int sec = startTime % 60;
        int min = startTime/60;
        String start = "";
        if (sec <= 10) {
            start = min + ":0" + sec;
        }
        else {
        start = min + ":" + sec; }
        main.getBossBar().setTitle(ChatColor.LIGHT_PURPLE + "Time Remaining: " + start);
        main.getBossBar().setColor(BarColor.PINK);
        main.getBossBar().setStyle(BarStyle.SOLID);
    }

}
