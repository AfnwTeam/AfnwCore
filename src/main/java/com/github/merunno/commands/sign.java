package com.github.merunno.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class sign implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("sign")) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("60")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] 終了1時間前です。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.AQUA + "終了1時間前", null, 3, 60, 1));
                    return true;
                } else if (args[0].equalsIgnoreCase("30")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] 終了30分前です。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.AQUA + "終了30分前", null, 3, 60, 1));
                    return true;
                } else if (args[0].equalsIgnoreCase("15")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] 終了15分前です。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.AQUA + "終了15分前", "そろそろ終了の準備をしよう。", 3, 60, 1));
                    return true;
                } else if (args[0].equalsIgnoreCase("15s")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] 開始15分前です。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.AQUA + "開始15分前", null, 3, 60, 1));
                    return true;
                } else if (args[0].equalsIgnoreCase("end")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] このフェイズは終了しました。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.YELLOW + "終了", "再起動が行われます。ロビーへ転送中...", 3, 180, 1));
                    return true;
                } else if (args[0].equalsIgnoreCase("start")) {
                    Bukkit.broadcastMessage(ChatColor.AQUA + "[AlertSign] フェイズがスタートしました。");
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(ChatColor.YELLOW + "開始", "ロビーの真ん中にあるポータルから参加", 3, 80, 1));
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.GREEN + "=== サイン ===");
                sender.sendMessage("/sign <timecode> | timecodeは下の通りです。");
                sender.sendMessage(ChatColor.GREEN + "60: " + ChatColor.WHITE + "一時間前通知");
                sender.sendMessage(ChatColor.GREEN + "30: " + ChatColor.WHITE + "30分前通知");
                sender.sendMessage(ChatColor.GREEN + "15: " + ChatColor.WHITE + "15分前通知");
                sender.sendMessage(ChatColor.GREEN + "end: " + ChatColor.WHITE + "終了通知");
                sender.sendMessage(ChatColor.GREEN + "15s: " + ChatColor.WHITE + "15分前通知(スタート)");
                sender.sendMessage(ChatColor.GREEN + "start: " + ChatColor.WHITE + "開始通知");
                return false;
            }
        }
        return true;
    }
}
