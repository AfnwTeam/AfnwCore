package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class join_first implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
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

        if (meta == null) return;
        meta.setTitle("Blank");
        meta.setAuthor("Afnw運営・AfnwCore開発者");
        meta.setDisplayName(ChatColor.YELLOW + "Afnw(A Fall New World)の遊び方 - Ver1");
        meta.addPage(page);
        item.setItemMeta(meta);

        if (!player.hasPlayedBefore()) {
            joinEvent.setJoinMessage(ChatColor.GRAY + "[AfnwCore] " + player.getName() + "がAfnwに初参加しました!");
            player.sendMessage("[AfnwCore] Afnwの遊び方を書いた本を配布しました。ぜひ一読ください。(/bookでいつでも呼び出せます。)");
            player.sendMessage(ChatColor.GREEN + "=== Afnwへようこそ！ ===");
            player.sendMessage("Afnwは投票でのみアイテムが手に入る特殊な状況下でサバイバルをする新感覚マルチサーバーです。");
            player.sendMessage("岩盤から広がるユーザーたちの輪に参加して謎の世界を生き抜こう。");
            player.sendMessage("ロビー真ん中のポータルの穴へ飛び込もう。プレイヤーが待っています!");
            player.sendMessage("まずは挨拶をして、交流を始めてみよう。");
            player.sendMessage(ChatColor.YELLOW + "注意：アジ鯖各サーバーと大きく違う点として公開時間が制限されています。");
            player.sendMessage(ChatColor.YELLOW + "詳しくは公式Discord \"#お知らせ|Afnw鯖\" をご覧ください。");
            player.sendMessage(ChatColor.YELLOW + "ルール:https://www.azisaba.net/server-intro/a-fall-new-world/#rule");
            player.sendMessage(ChatColor.GREEN + "===================");
            player.getInventory().addItem(item);
        }
    }
}
