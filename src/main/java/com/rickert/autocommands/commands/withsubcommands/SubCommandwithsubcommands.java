package com.rickert.autocommands.commands.withsubcommands;

import com.rickert.autocommands.CommandSource;
import com.rickert.autocommands.commands.subcommand.SubCommand;
import org.bukkit.Server;

public class SubCommandwithsubcommands extends SubCommand {

    public SubCommandwithsubcommands() {
        super("withsubcommands");
    }

    @Override
    public void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception {
        // code for subcommand
    }
}