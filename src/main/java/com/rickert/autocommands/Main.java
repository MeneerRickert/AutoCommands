package com.rickert.autocommands;

import com.rickert.autocommands.commands.ICommand;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

@Plugin(name = "AutoCommands", version = "1.0")
@Author(value = "MeneerRickert")
public class Main extends JavaPlugin implements IMain {

    private static IMain instance;
    private String pluginName;

    public static IMain getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            this.pluginName = model.getArtifactId().toLowerCase();
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }

        PluginManager pm = Bukkit.getPluginManager();
        registerListeners(pm);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        return onCommandPlugin(sender, command, commandLabel, args, Main.class.getClassLoader(),
                "com.rickert." + this.pluginName + ".commands.Command", this.pluginName + ".");
    }

    @Override
    public boolean onCommandPlugin(CommandSender sender, Command command, String commandLabel, String[] args,
                                   ClassLoader classLoader, String commandPath, String permissionPrefix) {
        if (sender == null) {
            return false;
        }

        CommandSource source = new CommandSource(sender);
        Player player = source.isPlayer() ? (Player) sender : null;

        ICommand cmd;
        try {
            cmd = (ICommand) classLoader.loadClass(commandPath + command.getName().toLowerCase()).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        if (player != null && !player.hasPermission(permissionPrefix + command.getName())) {
            player.sendMessage("You do not have permissions to do this.");
            return false;
        }

        try {
            cmd.run(getServer(), source, commandLabel, command, args);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String getPluginName() {
        return pluginName;
    }

    private void registerListeners(PluginManager pm) {

    }
}