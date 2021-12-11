package com.github.merunno.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class personal_chest implements CommandExecutor {

    String pluginAfnw = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("personal-chests")) {
            Player player = (Player) sender;
            player.openInventory(player.getEnderChest());
            sender.sendMessage(ChatColor.LIGHT_PURPLE + pluginAfnw + "個人チェスト(エンダーチェスト)を開きました。");
        }
        return true;
    }
}
