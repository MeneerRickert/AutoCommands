package com.rickert.autocommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public interface IMain extends Plugin {

    String getPluginName();
    boolean onCommandPlugin(CommandSender sender, Command command, String commandLabel, String[] args,
                            ClassLoader classLoader, String commandPath, String permissionPrefix);
}