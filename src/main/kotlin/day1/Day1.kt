package day1

import days.Day

class Day1 : Day(1) {

    override fun partOne(): Int {
        return inputList.joinToString("\n").split("\n\n").maxOfOrNull { it -> it.split("\n").sumOf { it.toInt() } }!!
    }

    override fun partTwo(): Int {
        return inputList.joinToString("\n").split("\n\n").map { it -> it.split("\n").sumOf { it.toInt() } }.sorted().takeLast(3).sum()
    }

}