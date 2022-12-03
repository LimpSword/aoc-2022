package day3

import java.io.File

fun main() {
    val lines = File("src/main/resources/day3").readLines()

    val map = HashMap<Char, Char>()
    var sum = 0

    lines.forEach {
        val first = it.take(it.length / 2)
        val last = it.takeLast(it.length / 2)
        map.clear()
        first.forEach { c ->
            map[c] = c
        }
        last.forEachIndexed { _, c ->
            if (map.containsKey(c)) {
                sum += if (c.isUpperCase()) {
                    c.code - 65 + 27
                } else {
                    c.code - 96
                }
                return@forEach
            }
        }
    }
    println(sum)
}