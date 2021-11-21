package com.github.merunno.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class open_personal_chests implements CommandExecutor {

    String pluginAfnw = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("open-personal-chests")) {
            Player player = (Player) sender;
            Player target = player.getServer().getPlayer(args[0]);
            Objects.requireNonNull(target).openInventory(target.getEnderChest());
            sender.sendMessage(ChatColor.LIGHT_PURPLE + pluginAfnw + target.getName() + "のパーソナルチェスト(エンダーチェスト)を開けました。");

            return true;
        }
        return true;
    }

}
