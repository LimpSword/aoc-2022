package day1

import java.io.File

operator fun String.times(n: Int): String {
    val sb = StringBuilder()
    repeat(n) {
        sb.append(this)
    }
    return sb.toString()
}


fun main() {
    val lines = File("src/main/resources/day1").readLines().joinToString("\n")
    println(lines.split("\n\n").map { it -> it.split("\n").sumOf { it.toInt() } }.sorted().takeLast(1).sum())
}