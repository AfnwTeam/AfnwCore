package com.github.merunno.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class vote implements CommandExecutor {

    String Vote = ChatColor.YELLOW + "★ " + ChatColor.WHITE;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("vote")) {
            sender.sendMessage(ChatColor.GREEN + "== Vote Site ==");
            sender.sendMessage(Vote + "Japan Minecraft Servers");
            sender.sendMessage(ChatColor.GREEN + " → https://minecraft.jp/servers/59b7c551a9b0bd23dc00834d");
            sender.sendMessage(Vote + "Monocraft");
            sender.sendMessage(ChatColor.GREEN + " → https://monocraft.net/servers/xWBVrf1nqB2P0LxlMm2v");
        }
        return false;
    }
}
