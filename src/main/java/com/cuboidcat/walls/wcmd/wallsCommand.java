package com.cuboidcat.walls.wcmd;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.world.worldStart;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class wallsCommand implements CommandExecutor {

    private static boolean enabled = false;
    private final Main main;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("walls.walls")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (enabled) {
                            player.sendMessage(ChatColor.RED + "Game in progress.");
                        } else {
                            enabled = true;
                            main.startTimer(1800);
                            new wallsBossbar(main);
                            try {
                                new worldStart(main);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if (enabled) {
                        enabled = false;
                        main.getTimer();
                        main.stopTimer(); }
                        else {
                            player.sendMessage(ChatColor.RED + "No game in progress.");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED.toString() + "INVALID USAGE");
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (enabled) {
                            player.sendMessage(ChatColor.RED + "Game in progress.");
                        } else {
                            int i = Integer.parseInt(args[1]);
                            enabled = true;
                            main.startTimer(i);
                            new wallsBossbar(main);
                            try {
                                new worldStart(main);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }




        return false;
    }


    public wallsCommand(Main main) {
        this.main = main;
    }
    public static void disable() {
        enabled = false;
    }

    public static boolean getEnabled() {
        return enabled;
    }
}
