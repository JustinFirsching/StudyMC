package com.justinfirsching.games.minecraft.plugins.studymc.problems

import com.justinfirsching.games.minecraft.plugins.studymc.Choices
import com.justinfirsching.games.minecraft.plugins.studymc.IProblem
import com.justinfirsching.games.minecraft.plugins.studymc.ProblemType

class MultipleChoiceProblem(
    override val problemStatement: String,
    override val choices: Choices,
    override val answer: String
) : IProblem {
    override val type = ProblemType.MultipleChoice

    override fun checkAnswer(playerAnswer: String): Boolean {
        return true
    }
}
