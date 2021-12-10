package com.justinfirsching.games.minecraft.plugins.studymc

import org.junit.Test
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.AbstractConstruct
import org.yaml.snakeyaml.constructor.Constructor
import org.yaml.snakeyaml.TypeDescription
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.nodes.Node
import org.yaml.snakeyaml.nodes.Tag
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.lang.reflect.Parameter
import java.net.URL

import com.justinfirsching.games.minecraft.plugins.studymc.problems.*
import com.justinfirsching.games.minecraft.plugins.studymc.yaml.*


class TestProblemSet {
    @Test
    fun testLoadProblemSet() {
        val problemsURL: URL = TestProblemSet::class.java.classLoader.getResource("TestProblems.yml")
        val problemsFile = File(problemsURL.toURI())
        val problemSet = ProblemSet.loadFromFile(problemsFile)
        println(problemSet)
    }
}
