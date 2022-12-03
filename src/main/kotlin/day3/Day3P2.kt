package day3

import java.io.File

fun main() {
    val lines = File("src/main/resources/day3").readLines()

    var sum = 0

    var counter = 0
    val rucksacks = arrayOf("", "", "")
    for (line in lines) {
        if (counter >= 2) {
            rucksacks[counter] = line

            val c = rucksacks.flatMap { it.toCharArray().distinct() }.groupBy { it }.maxByOrNull { it.value.size }?.key!!

            sum += if (c.isUpperCase()) {
                c.code - 65 + 27
            } else {
                c.code - 96
            }

            counter = 0
        } else {
            rucksacks[counter] = line
            counter++;
        }
    }
    println(sum)
}