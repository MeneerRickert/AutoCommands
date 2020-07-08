package com.rickert.autocommands.commands.subcommand;

import com.rickert.autocommands.CommandSource;
import org.bukkit.Server;

public interface ISubCommand {

    String getName();
    void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception;
}