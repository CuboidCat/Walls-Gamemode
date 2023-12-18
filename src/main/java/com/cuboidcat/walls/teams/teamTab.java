package com.cuboidcat.walls.teams;

import jdk.internal.joptsimple.internal.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class teamTab implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        List<String> results = new ArrayList<>();


        if (args.length == 1) {
            List<String> names = new ArrayList<>();
            for (Player e : Bukkit.getOnlinePlayers()) {
                names.add(e.getName());
            }
            return StringUtil.copyPartialMatches(args[0], names, new ArrayList<>());
        }
        if (args.length == 2) {
            return StringUtil.copyPartialMatches(args[1], Arrays.asList("red","blue","green","purple","spec"), new ArrayList<>());
        }



        return new ArrayList<>();
    }
}
