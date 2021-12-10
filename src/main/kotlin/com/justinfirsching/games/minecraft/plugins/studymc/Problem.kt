package com.justinfirsching.games.minecraft.plugins.studymc

import com.justinfirsching.extensions.isNumber

data class Problem(
    var type: ProblemType = ProblemType.Word,
    var problemStatement: String = "",
    var answer: String = "",
    var choices: Choices = Choices()
) {
    fun validate(): List<ProblemValidationErrors> {
        val errorList = ArrayList<ProblemValidationErrors>()

        if(problemStatement.isNullOrEmpty()) {
            errorList.add(ProblemValidationErrors.EmptyProblemStatement)
        }
        if(answer.isNullOrEmpty()) {
            errorList.add(ProblemValidationErrors.EmptyAnswer)
        }
        if(type == ProblemType.MultipleChoice && choices.numChoices == 0) {
            errorList.add(ProblemValidationErrors.MultipleChoiceProblemWithoutChoices)
        }
        if(type == ProblemType.Word && answer.isNumber()) {
            errorList.add(ProblemValidationErrors.NumericProblemUsingWordType)
        }
        if(type == ProblemType.Word && listOf("true", "false").contains(answer.lowercase())) {
            errorList.add(ProblemValidationErrors.TrueFalseProblemUsingWordType)
        }
        if(type == ProblemType.TrueFalse && choices != Choices(true, false)) {
            errorList.add(ProblemValidationErrors.TrueFalseRestrictedChoices)
        }
        return errorList
    }
}
