package days

import java.io.File

abstract class Day(dayNumber: Int) {

    private val inputLocation = "src/main/resources/day$dayNumber"

    // lazy delegate ensures the property gets computed only on first access
    protected val inputList: List<String> by lazy { File(inputLocation).readLines() }
    protected val inputString: String by lazy { File(inputLocation).readText() }

    abstract fun partOne(): Any

    abstract fun partTwo(): Any
}