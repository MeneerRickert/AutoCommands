package com.rickert.autocommands.commands;

import com.rickert.autocommands.CommandSource;
import com.rickert.autocommands.Main;
import com.rickert.autocommands.commands.subcommand.ISubCommand;
import org.bukkit.Server;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;

import static org.bukkit.Bukkit.getServer;

@Commands(@Command(name = "withsubcommands", desc = "Command with " + "subcommands"))
public class Commandwithsubcommands extends PluginCommand {

    public Commandwithsubcommands() {
        super("withsubcommands", true);
    }

    @Override
    public void run(Server server, CommandSource sender, String commandLabel, org.bukkit.command.Command cmd,
                    String[] args) throws Exception {
        // code for command

        // sub commands
        if (args.length > 0) {
            String commandString = args[0];
            ISubCommand subCommand;
            try {
                subCommand = (ISubCommand) Main.class.getClassLoader().loadClass(
                        "com.rickert." + Main.getInstance().getPluginName() + ".commands." + this.getName() + "." +
                                commandString.toLowerCase()).newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }

            try {
                subCommand.run(getServer(), sender, commandLabel, args);
            } catch (Exception ignore) {
            }
        }
    }
}