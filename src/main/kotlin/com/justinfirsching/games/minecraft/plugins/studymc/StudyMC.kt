package com.justinfirsching.games.minecraft.plugins.studymc

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.PluginLogger
import java.util.logging.Level
import java.io.File

class StudyMC : JavaPlugin() {
    val logger: PluginLogger = PluginLogger(this)
    val playerJoinListener = PlayerJoinListener(logger)

    override public fun onEnable() {
        logger.log(Level.FINE, "Registering Player Join Listener")
        server.pluginManager.registerEvents(playerJoinListener, this)
    }
}
