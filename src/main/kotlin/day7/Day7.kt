package day7

import days.Day
import java.io.File


class Day7 : Day(7) {

    private lateinit var tree: Node

    override fun parsing() {
        val lines = File("src/main/resources/day7").readLines()

        val tree = Node("/")
        var currentTree = tree
        for (line in lines) {
            when {
                line == "$ cd .." -> {
                    currentTree = currentTree.parent!!
                }

                line.matches("""\$ cd \w+""".toRegex()) -> {
                    currentTree = currentTree.getChild(line.split(" ")[2])
                }

                line.startsWith("dir") -> {
                    currentTree.addChild(Node(line.split(" ")[1]))
                }

                line.matches("""\d+.*""".toRegex()) -> {
                    currentTree.addChild(Node(line))
                }
            }
        }
        this.tree = tree
    }

    override fun partOne(): Int {
        var sum = 0
        tree.listAllDirectories().forEach {
            if (it.getSize() <= 100000) {
                sum += it.getSize()
            }
        }
        return sum
    }

    override fun partTwo(): Int {
        val unused = 70000000 - tree.getSize()
        val needed = 30000000 - unused

        return tree.listAllDirectories().filter { it.getSize() - needed >= 0 }.minBy { it.getSize() - needed }
            .getSize()
    }

}