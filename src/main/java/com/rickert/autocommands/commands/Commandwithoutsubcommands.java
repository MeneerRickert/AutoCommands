package com.rickert.autocommands.commands;

import com.rickert.autocommands.CommandSource;
import org.bukkit.Server;

public class Commandwithoutsubcommands extends PluginCommand{

    public Commandwithoutsubcommands() {
        super("withoutsubcommands");
    }

    @Override
    protected void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception {
        // code for command
    }
}