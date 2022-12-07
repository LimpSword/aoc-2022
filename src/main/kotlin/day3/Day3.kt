package day3

import days.Day


class Day3 : Day(3) {

    override fun parsing() {

    }

    override fun partOne(): Int {
        val map = HashMap<Char, Char>()
        var sum = 0

        inputList.forEach {
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
        return sum
    }

    override fun partTwo(): Int {
        var sum = 0
        var counter = 0
        val rucksacks = arrayOf("", "", "")
        for (line in inputList) {
            if (counter >= 2) {
                rucksacks[counter] = line

                val c = rucksacks.flatMap { it.toCharArray().distinct() }.groupBy { it }
                    .maxByOrNull { it.value.size }?.key!!

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
        return sum
    }

}