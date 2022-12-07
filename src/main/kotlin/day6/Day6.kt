package day6

import days.Day
import java.io.File

class Day6 : Day(6) {

    private lateinit var text: String

    override fun parsing() {
        text = File("src/main/resources/day6").readText()
    }

    override fun partOne(): Any {
        return text.windowed(4).indexOfFirst { it.toCharArray().distinct().size == 4 }
    }

    override fun partTwo(): Int {
        return text.windowed(14).indexOfFirst { it.toCharArray().distinct().size == 14 }
    }

}