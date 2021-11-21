package com.github.merunno.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.AQUA + "== AfnwCore Help ==");
            sender.sendMessage("https://github.com/merunno/AfnwCore");
            sender.sendMessage(ChatColor.AQUA + "/help" + "：" +ChatColor.WHITE + "ヘルプの表示");
            sender.sendMessage(ChatColor.AQUA + "/vote" + "：" +ChatColor.WHITE + "投票先リンク一覧を表示");
            sender.sendMessage(ChatColor.AQUA + "/trash" + "：" +ChatColor.WHITE + "ゴミ箱を表示");
            sender.sendMessage(ChatColor.AQUA + "/pc" + "：" +ChatColor.WHITE + "パーソナルチェストをオープン");
            sender.sendMessage(ChatColor.AQUA + "/about" + "：" +ChatColor.WHITE + "遊び方の本を呼び出す");
        } else if(command.getName().equalsIgnoreCase("about")) {
            Player player = (Player) sender;
            ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) item.getItemMeta();
            String[] page = {
                    // 1 Page
                    "\n\n\n" +
                            "§3§nAfnwの遊び方\n\n\n" +
                            "§0作者: める(TypeMeru)",
                    // 2 Page
                    "Afnwは生活鯖の一種になるマルチサーバーです。\n\n" +
                            "§6岩盤だけの世界§0で生活しアイテムの入手は投票でのみ獲得できる§6新感覚マルチサーバーです！§0\n\n" +
                            "Afnwでアイテムを入手するにはアジ鯖でお馴染みのJMS・MonoCraftでの投票が対象になります。\n\n",
                    // 3 Page
                    "Afnwのサポートは、\nアジ鯖Discordで行っています。\n\n" +
                            "§6 https://discord.gg/azisaba §0\n\n" +
                            "それでは....\n\n§2Afnwをお楽しみください！"
            };
            if (meta == null) return true;
            meta.setTitle("Blank");
            meta.setAuthor("Afnw運営・AfnwCore開発者");
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Afnw(A Fall New World)の遊び方");
            meta.addPage(page);
            item.setItemMeta(meta);

            player.getInventory().addItem(item);
            sender.sendMessage(ChatColor.YELLOW + "[AfnwCore] 遊び方の本を配布しました。");
        }
        return false;
    }
}
