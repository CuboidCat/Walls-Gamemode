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

public class endTimer {
    Timer timer;
    int seconds;
    private static Main main;

    public endTimer(int length, Main main) {
        seconds = length;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                if (seconds == 0) {
                    timer.stop();
                    Bukkit.getScheduler().runTask(main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            new worldEnd();
                        }
                    });
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}
