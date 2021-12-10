package com.justinfirsching.games.minecraft.plugins.studymc

import org.bukkit.entity.Player

interface ProblemOutcome {
    val permission: String
    fun shouldApply(player: Player, answeredCorrect: Boolean): Boolean
    fun apply(player: Player, problem: IProblem)
}
