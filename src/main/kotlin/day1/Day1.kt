package day1

import java.io.File

fun main() {
    val lines = File("src/main/resources/day1").readLines().joinToString("\n")
    println(lines.split("\n\n").map { it -> it.split("\n").sumOf { it.toInt() } }.sorted().takeLast(1).sum())
}
