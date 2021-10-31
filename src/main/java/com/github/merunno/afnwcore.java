package com.github.merunno;

import com.github.merunno.commands.trust;
import com.github.merunno.commands.vote;
import com.github.merunno.commands.randomitem;
import com.github.merunno.listener.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class afnwcore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Afnwの読み込みを開始します。");

        getLogger().info("コマンドの読み込み開始.....");
        Objects.requireNonNull(getCommand("vote")).setExecutor(new vote());
        Objects.requireNonNull(getCommand("randomitem")).setExecutor(new randomitem());
        Objects.requireNonNull(getCommand("trust")).setExecutor(new trust());
        getLogger().info("コマンドの読み込み.... Done.");

        getLogger().info("イベントの読み込み開始....");
        getServer().getPluginManager().registerEvents(new join(), this);
        getServer().getPluginManager().registerEvents(new join_first(), this);
        getServer().getPluginManager().registerEvents(new quit(), this);
        getServer().getPluginManager().registerEvents(new death(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(), this);
        getLogger().info("イベントの読み込み.... Done.");

        getLogger().info("Afnwの読み込みが完了しました。");
    }
}
