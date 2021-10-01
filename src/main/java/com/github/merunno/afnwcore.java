package com.github.merunno;

import com.github.merunno.commands.afnwcoreCommand;
import com.github.merunno.commands.randomitem;
import com.github.merunno.listener.join;
import com.github.merunno.listener.quit;
import com.github.merunno.listener.death;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class afnwcore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Afnwの読み込みを開始します。");

        getLogger().info("コマンドの読み込み開始.....");
        Objects.requireNonNull(getCommand("afnwcore")).setExecutor(new afnwcoreCommand());
        Objects.requireNonNull(getCommand("randomitem")).setExecutor(new randomitem());
        getLogger().info("コマンドの読み込み.... Done.");

        getLogger().info("イベントの読み込み....");
        getServer().getPluginManager().registerEvents(new join(), this);
        getServer().getPluginManager().registerEvents(new quit(), this);
        getServer().getPluginManager().registerEvents(new death(), this);
        getLogger().info("イベントの読み込み.... Done.");

        getLogger().info("Afnwの読み込みが完了しました。");
    }
}
