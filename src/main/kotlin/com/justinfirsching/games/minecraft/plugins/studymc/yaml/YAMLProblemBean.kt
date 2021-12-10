package com.justinfirsching.games.minecraft.plugins.studymc.yaml

import com.justinfirsching.games.minecraft.plugins.studymc.Choices
import com.justinfirsching.games.minecraft.plugins.studymc.ProblemType

class YAMLProblemBean(
    var type: ProblemType = ProblemType.Word,
    var problemStatement: String = "",
    var answer: String = "",
    // Set this one by default
    var caseSensitive: Boolean = false,
    var choices: List<String> = emptyList()
) {
    fun hasRequiredFields(): Boolean =
        !problemStatement.isNullOrEmpty() &&
        !answer.isNullOrEmpty()

    fun hasRequiredMultipleChoiceArguments(): Boolean =
        choices.size > 1
}
