package com.github.merunno.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class trust implements CommandExecutor {

    String prefix = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("trust")) {
            sender.sendMessage(prefix + "ゴミ箱を開きました。");
            display_gui((Player) sender);
        }
        return false;
    }

    public void display_gui(Player sender) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.RED + "ゴミ箱 : アイテムの消滅に注意");
        sender.openInventory(inv);
    }
}
