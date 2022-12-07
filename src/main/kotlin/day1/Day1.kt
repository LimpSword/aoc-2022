package day1

import days.Day

class Day1 : Day(1) {

    private lateinit var parsedInput: List<String>

    override fun parsing() {
        parsedInput = inputList.joinToString("\n").split("\n\n")
    }

    override fun partOne(): Int {
        return parsedInput.maxOfOrNull { it -> it.split("\n").sumOf { it.toInt() } }!!
    }

    override fun partTwo(): Int {
        return parsedInput.map { it -> it.split("\n").sumOf { it.toInt() } }.sorted().takeLast(3).sum()
    }

}