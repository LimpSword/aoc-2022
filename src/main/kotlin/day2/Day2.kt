package day2

import java.io.File

fun main() {
    val lines = File("src/main/resources/day2").readLines()
    var sum = 0
    lines.forEach {
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
    println(sum)
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