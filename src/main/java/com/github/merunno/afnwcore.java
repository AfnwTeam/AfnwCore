package com.github.merunno;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class afnwcore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Afnwを読み込みました。このプラグインはコンソールでのみ実行が可能です。");
        getServer().getPluginManager().registerEvents(new EventManager(), this);
        Objects.requireNonNull(getCommand("randomitem")).setExecutor(new CommandClass());
        Objects.requireNonNull(getCommand("vote-link")).setExecutor(new CommandClass());
    }
}
