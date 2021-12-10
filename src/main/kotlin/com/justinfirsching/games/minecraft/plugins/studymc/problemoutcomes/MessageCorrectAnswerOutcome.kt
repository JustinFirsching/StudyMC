package com.justinfirsching.games.minecraft.plugins.studymc

import org.bukkit.entity.Player

class MessageCorrectAnswerOutcome : ProblemOutcome {
    override val permission: String = "studymc.problemoutcome.messagecorrectanswer"

    override fun shouldApply(player: Player, answeredCorrect: Boolean): Boolean =
        // player.hasPermission(permission)
        true // Just assume we always have it for now

    override fun apply(player: Player, problem: IProblem) {
        player.sendMessage("The correct answer was: ${problem.answer}")
    }
}
