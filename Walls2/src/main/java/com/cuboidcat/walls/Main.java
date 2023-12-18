package com.cuboidcat.walls;

import com.cuboidcat.walls.barrier.delete;
import com.cuboidcat.walls.endGame.endGameListener;
import com.cuboidcat.walls.endGame.forceEnd;
import com.cuboidcat.walls.teams.setTeam;
import com.cuboidcat.walls.teams.teamListener;
import com.cuboidcat.walls.teams.teamTab;
import com.cuboidcat.walls.wcmd.wallsCommand;
import com.cuboidcat.walls.wcmd.wallsListener;
import com.cuboidcat.walls.wcmd.wallsTab;
import com.cuboidcat.walls.world.worldEnd;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static wallsTimer timer;
    private static Boolean timerOn;
    private static Plugin instance;
    private static BossBar bossBar = Bukkit.createBossBar(
            ChatColor.LIGHT_PURPLE + "Time Remaining: ",
            BarColor.PINK,
            BarStyle.SOLID);;
    @Override
    public void onEnable() {
        World world = Bukkit.createWorld(new WorldCreator("walls"));
        world.setAutoSave(false);
        Bukkit.getPluginManager().registerEvents(new wallsListener(this), this);
        getCommand("walls").setExecutor(new wallsCommand(this));
        getCommand("walls").setTabCompleter(new wallsTab());
        getCommand("setteam").setExecutor(new setTeam(this));
        getCommand("setteam").setTabCompleter(new teamTab());
        getCommand("walldelete").setExecutor(new delete(this));
        getCommand("wallsend").setExecutor(new forceEnd(this));
        Bukkit.getPluginManager().registerEvents(new teamListener(this), this);
        Bukkit.getPluginManager().registerEvents(new endGameListener(this), this);
        instance = this;
    }
    public void onDisable() {
        if (wallsCommand.getEnabled()) {
        new worldEnd(); }
    }

    public void startTimer(int length) {
        timer = new wallsTimer(length, this);
        timerOn = true;
    }

    public Plugin getInstance() {
        return instance;
    }
    public Boolean getTimerOn() {
        return timerOn;
    }
    public int getTimer() {
        return timer.getSeconds();
    }

    public void stopTimer() { timer.stop();}

    public BossBar getBossBar() {
        return bossBar;
    }
}
