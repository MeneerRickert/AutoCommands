package com.rickert.autocommands.commands;

import com.rickert.autocommands.CommandSource;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public interface ICommand extends CommandExecutor {

    String getName();

    void run(Server server, CommandSource sender, String commandLabel, Command cmd, String[] args) throws Exception;
}