package com.cuboidcat.walls;

import com.cuboidcat.walls.barrier.delete;
import com.cuboidcat.walls.barrier.deleteWalls;
import com.cuboidcat.walls.world.worldEnd;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wallsTimer {
    Timer timer;
    int seconds;
    private static Main main;

    public wallsTimer(int length, Main main) {
        this.main = main;
        seconds = length;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                String remain = "";
                int sec = seconds % 60;
                int min = seconds/60;
                if (sec >= 10) {
                    remain = min + ":" + sec;
                }
                else {
                    remain = min + ":0" + sec;
                }
                main.getBossBar().setTitle(ChatColor.LIGHT_PURPLE + "Time Remaining: " + remain);
                main.getBossBar().setProgress((double) seconds /length);
                if (seconds == 0) {
                    timer.stop();
                    Bukkit.getScheduler().runTask(main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            new deleteWalls();
                        }
                    });
                        main.getBossBar().removeAll();
                        for (Player a: Bukkit.getOnlinePlayers()) {
                           a.getWorld().playSound(a, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                           a.sendTitle("",ChatColor.RED + "The walls have fallen.",0,60,20);
                        }
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
        main.getBossBar().setProgress(1.0);
    }


    public int getSeconds(){
        return seconds;
    }
    public void stop() {
        timer.stop();
        main.getBossBar().removeAll();
        new worldEnd();
    }
}
