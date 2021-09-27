package com.github.merunno;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CommandClass implements CommandExecutor {

    String Vote = ChatColor.YELLOW + "★ " + ChatColor.WHITE;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("randomitem")) {
            String id = args[0];
            var player = Bukkit.getPlayer(id);
            List<Material> materials = Arrays.asList(Material.values());
            Collections.shuffle(materials);
            ItemStack itemStack = new ItemStack(materials.get(0), 8);
            Objects.requireNonNull(player).getInventory().addItem(itemStack);
        } else if (command.getName().equalsIgnoreCase("vote-link")) {
            sender.sendMessage(ChatColor.GREEN + "=== Vote Site ===");
            sender.sendMessage(Vote + "Japan Minecraft Servers");
            sender.sendMessage(ChatColor.GREEN + " → https://minecraft.jp/servers/59b7c551a9b0bd23dc00834d");
            sender.sendMessage(Vote + "Monocraft");
            sender.sendMessage(ChatColor.GREEN + " → https://monocraft.net/servers/xWBVrf1nqB2P0LxlMm2v");
        }
        return true;
    }

    private static boolean isAllowed(Material type) {
        if(!type.isItem()) return false;
        return type != Material.BEDROCK;
    }
}
