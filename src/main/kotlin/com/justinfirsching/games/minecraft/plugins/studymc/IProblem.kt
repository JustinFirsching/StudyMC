package com.justinfirsching.games.minecraft.plugins.studymc

interface IProblem {
    val type: ProblemType
    val problemStatement: String
    val answer: String
    val choices: Choices
    fun checkAnswer(playerAnswer: String): Boolean
}
