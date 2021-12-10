package com.justinfirsching.games.minecraft.plugins.studymc

import org.bukkit.entity.Player

interface ProblemSender {
    val problemSets: List<ProblemSet>
    fun sendProblem(player: Player)
}
