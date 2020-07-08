package com.rickert.autocommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSource {

    protected CommandSender sender;

    public CommandSource(final CommandSender sender) {
        this.sender = sender;
    }

    public final CommandSender getSender() {
        return this.sender;
    }

    public final void setSender(final CommandSender sender) {
        this.sender = sender;
    }

    public final Player getPlayer() {
        if (this.sender instanceof Player) {
            return (Player) this.sender;
        }
        return null;
    }

    public final boolean isPlayer() {
        return (sender instanceof Player);
    }

    public void sendMessage(String message) {
        if (!message.isEmpty()) {
            this.sender.sendMessage(message);
        }
    }
}