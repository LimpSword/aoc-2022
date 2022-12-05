package day4

import days.Day

class Day4 : Day(4) {

    override fun partOne(): Int {
        var count = 0

        inputList.forEach {
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
            }
        }
        return count
    }

    override fun partTwo(): Any {
        var count = 0

        inputList.forEach {
            val sections = it.split(",")
            val firstLeft = sections[0].split("-")[0].toInt()
            val firstRight = sections[0].split("-")[1].toInt()
            val secondLeft = sections[1].split("-")[0].toInt()
            val secondRight = sections[1].split("-")[1].toInt()

            if (firstLeft in secondLeft..secondRight || firstRight in secondLeft..secondRight) {
                count++ // overlaps
            } else if (secondLeft in firstLeft..firstRight || secondRight in firstLeft..firstRight) {
                count++ // overlaps
            }
        }
        return count
    }
}