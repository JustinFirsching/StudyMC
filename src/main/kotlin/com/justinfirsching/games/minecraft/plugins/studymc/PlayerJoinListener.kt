package com.justinfirsching.games.minecraft.plugins.studymc;

import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginLogger
import java.util.logging.Level

class PlayerJoinListener(private val logger: PluginLogger) : Listener {
    @EventHandler
    public fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.getPlayer()
        val millisSinceLastPlayed = System.currentTimeMillis() - player.lastPlayed;
        logger.log(Level.INFO, "${player.lastPlayed} - $millisSinceLastPlayed ")
    }
}
