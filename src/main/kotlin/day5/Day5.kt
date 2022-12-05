package day5

import days.Day

class Day5 : Day(5) {

    override fun partOne(): Any {
        val map = HashMap<Int, ArrayDeque<Char>>()
        var count = 0
        for (line in inputList) {
            if (line.startsWith("move")) {
                val split = line.split(" ")
                val amount = split[1].toInt()
                val from = split[3].toInt() - 1
                val to = split[5].toInt() - 1

                for (i in 1..amount) {
                    val first = map[from]!!.first()
                    map[from]!!.removeFirst()
                    map[to]!!.addFirst(first)
                }
            } else {
                if (!(line.startsWith(" 1") || line == "")) {
                    val charArray = line.toCharArray()
                    for (i in charArray.indices step 4) {
                        val second = charArray[i + 1]
                        if (second != ' ') {
                            if (map.containsKey(count)) {
                                val current = map[count]
                                current!!.addLast(second)
                                map[count] = current
                            } else {
                                val toAdd = ArrayDeque<Char>()
                                toAdd.add(second)
                                map[count] = toAdd
                            }
                        }
                        count++
                    }
                    count = 0
                }
            }
        }
        return map.entries.map { it.value.first() }.joinToString("")
    }

    override fun partTwo(): Any {
        val map = HashMap<Int, ArrayDeque<Char>>()
        var count = 0
        for (line in inputList) {
            if (line.startsWith("move")) {
                val split = line.split(" ")
                val amount = split[1].toInt()
                val from = split[3].toInt() - 1
                val to = split[5].toInt() - 1

                for (i in amount - 1 downTo 0) {
                    val first = map[from]!![i]
                    map[from]!!.removeAt(i)
                    map[to]!!.addFirst(first)
                }
            } else {
                if (!(line.startsWith(" 1") || line == "")) {
                    val charArray = line.toCharArray()
                    for (i in charArray.indices step 4) {
                        val second = charArray[i + 1]
                        if (second != ' ') {
                            if (map.containsKey(count)) {
                                val current = map[count]
                                current!!.addLast(second)
                                map[count] = current
                            } else {
                                val toAdd = ArrayDeque<Char>()
                                toAdd.add(second)
                                map[count] = toAdd
                            }
                        }
                        count++
                    }
                    count = 0
                }
            }
        }
        return map.entries.map { it.value.first() }.joinToString("")
    }

}