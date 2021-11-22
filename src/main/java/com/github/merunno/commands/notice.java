package com.github.merunno.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class notice implements CommandExecutor {

    String prefix = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("notice")) {
            String noticeMessage = args[0];
            if (noticeMessage == null) {
                sender.sendMessage(ChatColor.RED + prefix + "通知内容を第一引数で指定してください。");
                return true;
            }

            Bukkit.getServer().broadcastMessage(ChatColor.RED + prefix + noticeMessage);
            sender.sendMessage(ChatColor.YELLOW + "通知を行いました。");

        }
        return true;
    }
}
