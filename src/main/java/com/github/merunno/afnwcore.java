package com.github.merunno;

import com.github.merunno.commands.*;
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
        Objects.requireNonNull(getCommand("trash")).setExecutor(new trash());
        Objects.requireNonNull(getCommand("personal-chests")).setExecutor(new personal_chest());
        Objects.requireNonNull(getCommand("help")).setExecutor(new help());
        Objects.requireNonNull(getCommand("book")).setExecutor(new help());
        Objects.requireNonNull(getCommand("sign")).setExecutor(new sign());
        getLogger().info("コマンドの読み込み.... Done.");

        getLogger().info("イベントの読み込み開始....");
        getServer().getPluginManager().registerEvents(new join(), this);
        getServer().getPluginManager().registerEvents(new join_first(), this);
        getServer().getPluginManager().registerEvents(new quit(), this);
        getServer().getPluginManager().registerEvents(new saplingBreakCanceller(), this);
        getServer().getPluginManager().registerEvents(new CropsBreakCanceller(), this);
        getServer().getPluginManager().registerEvents(new brew(), this);
        getLogger().info("イベントの読み込み.... Done.");

        getLogger().info("Afnwの読み込みが完了しました。");
    }
}
