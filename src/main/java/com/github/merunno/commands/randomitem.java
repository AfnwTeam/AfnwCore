package com.github.merunno.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class randomitem implements CommandExecutor {

    String pluginAfnw = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("randomitem")) {
            String id = args[0];
            var player = Bukkit.getPlayer(id);
            if (player == null) {
                return true;
            }
            Inventory player_inventory = player.getInventory();
            Location loc = player.getLocation();
            int emptySlot = player_inventory.firstEmpty();
            if (emptySlot == -1) {
                player.sendMessage(ChatColor.RED + pluginAfnw + "アイテムの配布に失敗しました。");
                player.sendMessage(ChatColor.RED + "インベントリがいっぱいで配布できませんでした。次回以降は整理してから投票を行ってください。");
                inventory_sound(loc);
                return true;
            }
            List<Material> materials = Arrays.asList(Material.values());
            Collections.shuffle(materials);
            ItemStack itemStack = new ItemStack(materials.get(0), 8);
            Objects.requireNonNull(player).getInventory().addItem(itemStack);
            player.sendMessage(ChatColor.YELLOW + pluginAfnw + "アイテムの配布に成功しました。");
            sound(loc);
            particle(loc);
            if(loc.getWorld() != null) {
                return true;
            }
        }
        return true;
    }

    private static boolean isAllowed(Material type) {
        if (!type.isItem()) return false;
        return type != Material.BEDROCK;
    }

    private void sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 1, 1);
    }

    private void particle(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playEffect(loc, Effect.DRAGON_BREATH, 0, 14);
    }


    public void inventory_sound(Location loc) {
        Objects.requireNonNull(loc.getWorld()).playSound(loc, Sound.BLOCK_ANVIL_DESTROY, 1, 1);
    }
}
