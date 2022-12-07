package day6

import days.Day
import java.io.File

class Day6 : Day(6) {
    override fun parsing() {

    }

    override fun partOne(): Any {
        val lines = File("src/main/resources/day6").readText()

        var counter = 0
        for (i in 0..lines.length - 3) {
            if (lines.substring(i, i + 4).toCharArray().toSet().size == 4) {
                break
            }
            counter++
        }
        return counter + 4
    }

    override fun partTwo(): Int {
        val lines = File("src/main/resources/day6").readText()

        var counter = 0
        for (i in 0..lines.length - 13) {
            if (lines.substring(i, i + 14).toCharArray().toSet().size == 14) {
                break
            }
            counter++
        }
        return counter + 14
    }

}