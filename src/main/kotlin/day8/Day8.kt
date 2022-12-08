package day8

import days.Day


class Day8 : Day(8) {

    private lateinit var matrix: Array<Array<Int>>

    override fun parsing() {
        matrix = Array(99) { Array(99) { 0 } }
        for ((counter, line) in inputList.withIndex()) {
            for ((subCounter, c) in line.toCharArray().withIndex()) {
                matrix[counter][subCounter] = c.digitToInt()
            }
        }
    }

    override fun partOne(): Int {
        var visible = 4 * 99 - 4

        for (i in 1 until matrix.size - 1) {
            for (j in 1 until matrix[i].size - 1) {
                val toCheck = matrix[i][j]

                val ok = (0 until i).none { matrix[it][j] >= toCheck }
                        || (i + 1 until matrix.size).none { matrix[it][j] >= toCheck }
                        || (0 until j).none { matrix[i][it] >= toCheck }
                        || (j + 1 until matrix[i].size).none { matrix[i][it] >= toCheck }

                if (ok) {
                    visible++
                }
            }
        }
        return visible
    }

    override fun partTwo(): Int {
        var max = 0

        for (i in 1 until matrix.size - 1) {
            for (j in 1 until matrix[i].size - 1) {
                val toCheck = matrix[i][j]

                var l = 0
                for (a in i - 1 downTo 0) {
                    if (matrix[a][j] < toCheck) {
                        l++
                    } else {
                        l++
                        break
                    }
                }
                var r = 0
                for (b in i + 1 until matrix.size) {
                    if (matrix[b][j] < toCheck) {
                        r++
                    } else {
                        r++
                        break
                    }
                }

                var t = 0
                for (c in j - 1 downTo 0) {
                    if (matrix[i][c] < toCheck) {
                        t++
                    } else {
                        t++
                        break
                    }
                }
                var b = 0
                for (d in j + 1 until matrix[i].size) {
                    if (matrix[i][d] < toCheck) {
                        b++
                    } else {
                        b++
                        break
                    }
                }

                max = kotlin.math.max(l * r * t * b, max)
            }
        }
        return max
    }

}