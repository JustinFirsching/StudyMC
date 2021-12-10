package com.justinfirsching.games.minecraft.plugins.studymc.problems

import com.justinfirsching.games.minecraft.plugins.studymc.Choices
import com.justinfirsching.games.minecraft.plugins.studymc.IProblem
import com.justinfirsching.games.minecraft.plugins.studymc.ProblemType

class TrueFalseProblem(
    override val problemStatement: String,
    answer: Boolean
) : IProblem {

    override val type: ProblemType = ProblemType.TrueFalse
    override val answer: String = answer.toString();
    override val choices = Choices(true, false)

    override fun checkAnswer(playerAnswer: String): Boolean {
        val cleanAnswer = playerAnswer.lowercase().trim();
        return listOf(
            "true",
            "yes",
            "1"
        ).map {
            it.startsWith(cleanAnswer)
        }.any()
    }
}
