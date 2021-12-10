package com.justinfirsching.games.minecraft.plugins.studymc

enum class ProblemValidationErrors {
    EmptyProblemStatement,
    EmptyAnswer,
    MultipleChoiceProblemWithoutChoices,
    NumericProblemUsingWordType,
    TrueFalseProblemUsingWordType,
    TrueFalseRestrictedChoices,
}
