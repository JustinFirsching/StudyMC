package com.justinfirsching.games.minecraft.plugins.studymc

import org.bukkit.plugin.PluginLogger
import java.util.logging.Level

object Logger {
    var logger: PluginLogger? = null
    fun log(level: Level, message: String): Unit = logger?.log(level, message) ?: Unit
    fun info(message: String): Unit = logger?.info(message) ?: Unit
    fun fine(message: String): Unit = logger?.fine(message) ?: Unit
    fun warning(message: String): Unit = logger?.warning(message) ?: Unit
    fun severe(message: String): Unit = logger?.severe(message) ?: Unit
}
