package com.rickert.autocommands.commands.subcommand;

import com.rickert.autocommands.CommandSource;
import org.bukkit.Server;

public abstract class SubCommand implements ISubCommand {

    private final String name;

    protected SubCommand(final String name) {
        this.name = name;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception {
        run(server, sender, commandLabel, args);
    }
}