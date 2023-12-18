package com.cuboidcat.walls.barrier;

import com.cuboidcat.walls.Main;
import com.cuboidcat.walls.endGame.endGame;
import com.cuboidcat.walls.teams.teamTablist;
import com.cuboidcat.walls.wcmd.wallsCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class  delete implements CommandExecutor {
    Main main;
    public delete(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        new deleteWalls();
        return false;
    }
}
