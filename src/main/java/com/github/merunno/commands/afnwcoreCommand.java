package com.github.merunno.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class afnwcoreCommand implements CommandExecutor {

    String Vote = ChatColor.YELLOW + "★ " + ChatColor.WHITE;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("afnwcore")) {
            sender.sendMessage(ChatColor.AQUA + "Usage :: /afnwcore <options>");
            if (strings[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.AQUA + "== AfnwCore Help ==");
                sender.sendMessage(ChatColor.AQUA + "/afnwcore <options>");
                sender.sendMessage(ChatColor.AQUA + "help ： " + ChatColor.WHITE + "ヘルプを表示します。");
                sender.sendMessage(ChatColor.AQUA + "vote ： " + ChatColor.WHITE + "投票先URLを表示します。");
            } else if (strings[0].equalsIgnoreCase("vote")) {
                sender.sendMessage(ChatColor.GREEN + "== Vote Site ==");
                sender.sendMessage(Vote + "Japan Minecraft Servers");
                sender.sendMessage(ChatColor.GREEN + " → https://minecraft.jp/servers/59b7c551a9b0bd23dc00834d");
                sender.sendMessage(Vote + "Monocraft");
                sender.sendMessage(ChatColor.GREEN + " → https://monocraft.net/servers/xWBVrf1nqB2P0LxlMm2v");
            }
        }
        return false;
    }
}
