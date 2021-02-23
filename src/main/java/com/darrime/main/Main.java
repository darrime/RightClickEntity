package com.darrime.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Main extends JavaPlugin implements Listener {
    Logger logger = getServer().getLogger();

    @Override
    public void onEnable() {
        logger.info(ChatColor.YELLOW + "[SYSTEM] 플러그인 활성화");
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
    }

    @Override
    public void onDisable() {
        logger.info(ChatColor.RED + "[SYSTEM] 플러그인 비활성화");
    }
}

