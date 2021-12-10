package com.justinfirsching.games.minecraft.plugins.studymc.problems

import com.justinfirsching.games.minecraft.plugins.studymc.Choices
import com.justinfirsching.games.minecraft.plugins.studymc.IProblem
import com.justinfirsching.games.minecraft.plugins.studymc.ProblemType

class NumericProblem(
    override val problemStatement: String,
    answer: Float
) : IProblem {
    override val type: ProblemType = ProblemType.Numeric
    override val answer: String = answer.toString()
    override val choices = Choices()

    override fun checkAnswer(playerAnswer: String) : Boolean =
        playerAnswer.toFloatOrNull()?.equals(answer) ?: false
}
