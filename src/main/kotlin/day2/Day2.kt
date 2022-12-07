package day2

import days.Day

class Day2 : Day(2) {

    override fun parsing() {

    }

    override fun partOne(): Int {
        var sum = 0
        inputList.forEach {
            val yourLetter = it.split(" ")[1]

            var points = 0
            points += when (it) {
                "A X" -> 3
                "A Y" -> 6
                "A Z" -> 0
                "B X" -> 0
                "B Y" -> 3
                "B Z" -> 6
                "C X" -> 6
                "C Y" -> 0
                "C Z" -> 3
                else -> 0
            }

            sum += points + letterGain(yourLetter)
        }
        return sum
    }

    override fun partTwo(): Any {
        var sum = 0
        inputList.forEach {
            val opponentLetter = it.split(" ")[0]
            val yourLetter = it.split(" ")[1]

            var usedLetter = ""
            var points = 0
            when (yourLetter) {
                "X" -> {
                    usedLetter = getLoseLetter(opponentLetter)
                }

                "Y" -> {
                    usedLetter = getDrawLetter(opponentLetter)
                    points = 3
                }

                "Z" -> {
                    usedLetter = getWinLetter(opponentLetter)
                    points = 6
                }
            }

            sum += points + letterGain(usedLetter)
        }
        return sum
    }
}

fun getLoseLetter(opponentLetter: String): String {
    return when (opponentLetter) {
        "A" -> "Z"
        "B" -> "X"
        "C" -> "Y"
        else -> ""
    }
}

fun getDrawLetter(opponentLetter: String): String {
    return when (opponentLetter) {
        "A" -> "X"
        "B" -> "Y"
        "C" -> "Z"
        else -> ""
    }
}

fun getWinLetter(opponentLetter: String): String {
    return when (opponentLetter) {
        "A" -> "Y"
        "B" -> "Z"
        "C" -> "X"
        else -> ""
    }
}

fun letterGain(letter: String): Int {
    return when (letter) {
        "X" -> {
            1
        }

        "Y" -> {
            2
        }

        "Z" -> {
            3
        }

        else -> {
            0
        }
    }
}