package com.cuboidcat.walls.teams;

import com.cuboidcat.walls.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setTeam implements CommandExecutor {
    private final Main main;


    public setTeam(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Boolean isPlayer = false;
            Player selection = null;
            Player player = (Player) commandSender;
            if (player.hasPermission("walls.teams")) {
            if (args.length >= 1) {
            for (Player e : Bukkit.getOnlinePlayers()) {
                if (e.getName().equalsIgnoreCase(args[0])) {
                    isPlayer = true;
            }}
            if (isPlayer) {
                selection = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 2) {
                new TeamStore(selection.getUniqueId(), args[1], main);
                teamTablist.newTeam(selection,args[1]);
            }
            else if (args.length == 1){
                player.sendMessage(ChatColor.RED + "Please provide team name.");
            }}
           }else {
                player.sendMessage(ChatColor.RED + "Please provide player and team name.");
        }}
            }





        return false;
    }
}
