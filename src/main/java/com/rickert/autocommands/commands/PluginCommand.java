package com.rickert.autocommands.commands;

import com.rickert.autocommands.CommandSource;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class PluginCommand implements ICommand {

    private final String name;
    private final boolean subcommands;

    protected PluginCommand(final String name) {
        this(name, false);
    }

    protected PluginCommand(final String name, final boolean subcommands) {
        this.name = name;
        this.subcommands = subcommands;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public void run(Server server, CommandSource sender, String commandLabel, Command cmd, String[] args)
            throws Exception {
        if (!this.subcommands) {
            run(server, sender, commandLabel, args);
            return;
        }
        run(server, sender, commandLabel, cmd, args);
    }

    protected void run(Server server, CommandSource sender, String commandLabel, String[] args) throws Exception {
        run(server, sender, commandLabel, args);
    }

    @Deprecated
    @Override
    public final boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s,
                             String[] strings) {
        return false;
    }
}