package com.github.merunno.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class hoten implements CommandExecutor {

    String pluginAfnw = "[AfnwCore] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hoten")) {
            String id = args[0];
            var player = Bukkit.getPlayer(id);
            if (player == null) {
                return true;
            }
            Inventory player_inventory = player.getInventory();
            Location loc = player.getLocation();
            int emptySlot = player_inventory.firstEmpty();
            if (emptySlot == -1) {
                player.sendMessage(ChatColor.RED + pluginAfnw + "運営による補填に失敗しました。");
                player.sendMessage(ChatColor.RED + pluginAfnw + "インベントリがいっぱいで配布できませんでした。再度運営に連絡してください。");
                sender.sendMessage(ChatColor.RED + pluginAfnw + "補填に失敗");
                inventory_sound(loc);
                return true;
            }
            List<Material> materials = new ArrayList<>(Arrays.asList(Material.values()));
            Collections.shuffle(materials);
            materials.removeIf(type -> !isAllowed(type));
            ItemStack voteScaffold = new ItemStack(Material.SCAFFOLDING, 8);
            ItemStack voteItem = new ItemStack(materials.get(0), 8);
            ItemMeta meta = voteScaffold.getItemMeta();
            Objects.requireNonNull(meta).setDisplayName(ChatColor.AQUA + "足場ブロック");
            List<String> lores = new ArrayList<>();
            lores.add("投票特典として獲得した足場として使えるブロックです。");
            meta.setLore(lores);
            voteScaffold.setItemMeta(meta);
            Objects.requireNonNull(player).getInventory().addItem(voteScaffold);
            Objects.requireNonNull(player).getInventory().addItem(voteItem);
            player.sendMessage(ChatColor.YELLOW + pluginAfnw + "補填に成功しました。ご迷惑おかけしました。");
            Bukkit.broadcastMessage(ChatColor.YELLOW + pluginAfnw + player.getName() + "が投票(補填)でアイテムを獲得しました。");
            sender.sendMessage(ChatColor.AQUA + pluginAfnw + player.getName() + "に対して補填を実行しました。お相手にご確認のメッセージを送ってください。");
            Bukkit.getServer().getLogger().info("[AfnwCore::補填] " + sender.getName() + " - " + player.getName() + " >>> " + voteItem.getType());
            sound(loc);
            particle(loc);
            if (loc.getWorld() != null) {
                return true;
            }
        }
        return true;
    }

    private static boolean isAllowed(Material type) {
        if (!type.isItem()) return false;
        switch (type) {
            case BEDROCK:
            case STRUCTURE_BLOCK:
            case STRUCTURE_VOID:
            case COMMAND_BLOCK:
            case CHAIN_COMMAND_BLOCK:
            case COMMAND_BLOCK_MINECART:
            case REPEATING_COMMAND_BLOCK:
            case BARRIER:
            case LIGHT:
            case JIGSAW:
            case DEBUG_STICK:
            case END_PORTAL:
            case KNOWLEDGE_BOOK:
                return false;
            default:
                return true;
        }
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
