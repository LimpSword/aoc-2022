package day4

import java.io.File

fun main() {
    val lines = File("src/main/resources/day4").readLines()

    var count = 0

    lines.forEach {
        val sections = it.split(",")
        val firstLeft = sections[0].split("-")[0].toInt()
        val firstRight = sections[0].split("-")[1].toInt()
        val secondLeft = sections[1].split("-")[0].toInt()
        val secondRight = sections[1].split("-")[1].toInt()

        // First two if are optional when we consider the overlaps
        if (firstLeft in secondLeft..secondRight && firstRight in secondLeft..secondRight) {
            count++
        } else if (secondLeft in firstLeft..firstRight && secondRight in firstLeft..firstRight) {
            count++
        } else if (firstLeft in secondLeft..secondRight || firstRight in secondLeft..secondRight) {
            count++ // overlaps
        } else if (secondLeft in firstLeft..firstRight || secondRight in firstLeft..firstRight) {
            count++ // overlaps
        }
    }
    println(count)
}