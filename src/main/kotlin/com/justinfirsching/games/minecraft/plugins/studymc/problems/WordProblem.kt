package com.justinfirsching.games.minecraft.plugins.studymc.problems

import com.justinfirsching.games.minecraft.plugins.studymc.Choices
import com.justinfirsching.games.minecraft.plugins.studymc.IProblem
import com.justinfirsching.games.minecraft.plugins.studymc.ProblemType

class WordProblem(
    override val problemStatement: String,
    override val answer: String,
    private val caseSensitive: Boolean
) : IProblem {
    override val type = ProblemType.Word
    override val choices = Choices()

    override fun checkAnswer(playerAnswer: String): Boolean =
        playerAnswer.equals(playerAnswer, !caseSensitive)
}
