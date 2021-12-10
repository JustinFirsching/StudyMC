package com.justinfirsching.games.minecraft.plugins.studymc

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.net.URI
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import org.yaml.snakeyaml.TypeDescription

import com.justinfirsching.games.minecraft.plugins.studymc.problems.*
import com.justinfirsching.games.minecraft.plugins.studymc.yaml.*

class ProblemSet private constructor(
    val name: String,
    val author: String,
    val version: String,
    private val problems: List<IProblem>
) {

    fun getRandomProblem(): IProblem = problems.random()

    fun isProblemInSet(problem: IProblem): Boolean = problems.contains(problem)

    companion object {
        fun loadFromFile(file: File): ProblemSet {
            val yaml: Yaml = Yaml(Constructor(YAMLDocument::class.java))
            val document: YAMLDocument = yaml.load(FileInputStream(file))

            val problems = document.problems.filter { problem: YAMLProblemBean ->
                val hasMinimumFields = problem.hasRequiredFields()
                val hasMultipleChoiceIfMultipleChoice =
                    problem.type == ProblemType.MultipleChoice == problem.hasRequiredMultipleChoiceArguments()
                hasMinimumFields && hasMultipleChoiceIfMultipleChoice
            }.map { problem: YAMLProblemBean ->
                when(problem.type) {
                    ProblemType.MultipleChoice -> MultipleChoiceProblem(problem.problemStatement, Choices(problem.choices), problem.answer)
                    ProblemType.TrueFalse -> TrueFalseProblem(problem.problemStatement, problem.answer.toBoolean())
                    ProblemType.Numeric -> NumericProblem(problem.problemStatement, problem.answer.toFloat())
                    ProblemType.Word -> WordProblem(problem.problemStatement, problem.answer, problem.caseSensitive)
                }
            }

            return ProblemSet(document.name, document.author, document.version, problems)
        }
    }
}
