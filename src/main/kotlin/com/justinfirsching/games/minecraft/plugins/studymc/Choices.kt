package com.justinfirsching.games.minecraft.plugins.studymc

class Choices(list: List<Any> = emptyList()) {
    constructor(vararg items: Any) : this(items.toList())

    val choices: List<Choice> = list.mapIndexed { index, value ->
        Choice(index.toString(), value.toString())
    }

    var numChoices: Int = choices.size
        get() = choices.size
        private set

    fun getChoiceByIdentifier(identifier: String): Choice? =
        choices.firstOrNull{ choice ->
            choice.id.equals(identifier)
        }

    fun getChoiceByDescription(description: String): Choice? =
        choices.firstOrNull{ choice ->
            choice.description.equals(description)
        }

    override fun equals(other: Any?) =
        // The other has to be Choices
        (other is Choices) &&
        // Every choice in this Choices has to be in the other
        choices.all { choice ->
            getChoiceByDescription(choice.description) != null
        } &&
        // Every choice in the Other has to be in this
        other.choices.all { choice ->
            other.getChoiceByDescription(choice.description) != null
        }
        // Don't bother checking identifiers since we may shuffle them
}
