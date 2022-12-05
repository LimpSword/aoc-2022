package Day5

import java.io.File

fun main() {
    val lines = File("src/main/resources/day5").readLines()

    val map = HashMap<Int, ArrayDeque<Char>>()
    var count = 0
    for (line in lines) {
        if (line.startsWith("move")) {
            val split = line.split(" ")
            val amount = split[1].toInt()
            val from = split[3].toInt() - 1
            val to = split[5].toInt() - 1

            // Part 1
            /*for (i in 1..amount) {
                val first = map[from]!!.first()
                map[from]!!.removeFirst()
                map[to]!!.addFirst(first)
            }*/

            // Part 2
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
    for (entry in map.entries) {
        print(entry.value.first())
    }
}