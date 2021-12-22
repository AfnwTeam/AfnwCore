package com.github.merunno.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

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
                player.sendMessage(ChatColor.RED + "==== 配布に失敗 ====");
                player.sendMessage(ChatColor.RED + "インベントリが満ぱんのため、AfnwCoreは配布に失敗しました。このメッセージを公式Discord \"#投票補填｜afnw鯖\" に送信してください。");
                player.sendMessage(ChatColor.GREEN + "◆ インベントリの整理に最適な方法： ◆");
                player.sendMessage("/personal-chests(/pc)：個人チェスト(パーソナルチェスト)を使用");
                player.sendMessage("/trash：ゴミ箱を使用");
                player.sendMessage(ChatColor.GREEN + "◆ [運営用] プレイヤー情報： ◆");
                player.sendMessage(ChatColor.RED + "インベントリを整理してもらってから配布してください。");
                player.sendMessage(ChatColor.LIGHT_PURPLE + "MCID:" + ChatColor.WHITE + player.getName());
                player.sendMessage(ChatColor.LIGHT_PURPLE + "UUID:" + ChatColor.WHITE + player.getUniqueId());
                player.sendMessage(ChatColor.LIGHT_PURPLE + "今いるワールド:" + ChatColor.WHITE + player.getWorld().getName());
                player.sendMessage("補填：/hoten " + player.getName());
                player.sendMessage("インベントリ操作：/oi " + player.getName());
                player.sendMessage(ChatColor.RED + "==================");
                player.sendTitle(ChatColor.RED + "配布に失敗しました。", "投票ありがとうございます....インベントリ整理は必ず！", 3, 60, 1);
                Bukkit.getLogger().warning(ChatColor.RED + "[AfnwCore::アイテム配布] " + player.getName() + "が投票を行い、アイテムを獲得しようとしましたが失敗しました。");
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
            lores.add("みなさんのご要望で土からアップグレードされました。やったね！あじちゃん！");
            meta.setLore(lores);
            voteScaffold.setItemMeta(meta);
            Objects.requireNonNull(player).getInventory().addItem(voteScaffold);
            Objects.requireNonNull(player).getInventory().addItem(voteItem);
            player.sendMessage(ChatColor.YELLOW + pluginAfnw + "アイテムの配布に成功しました。");
            player.sendTitle(ChatColor.YELLOW + "投票ありがとうございます!", null, 3, 60, 1);
            Bukkit.broadcastMessage(ChatColor.GRAY + pluginAfnw + player.getName() + "が投票でアイテムを獲得しました。");
            Bukkit.getServer().getLogger().info("[AfnwCore::アイテム配布] " + player.getName() + " >>> " + voteItem.getType());
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
            case END_PORTAL:
            case KNOWLEDGE_BOOK:
            case DEBUG_STICK:
            case BUNDLE:
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
