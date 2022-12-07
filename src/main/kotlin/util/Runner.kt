package util

import days.Day
import org.reflections.Reflections
import org.reflections.util.ConfigurationBuilder
import kotlin.math.max
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue


@ExperimentalTime
object Runner {

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isNotEmpty()) {
            val day = try {
                args[0].toInt()
            } catch (e: NumberFormatException) {
                printError("Day argument must be an integer")
                return
            }

            val dayClass = getAllDayClasses()?.find { dayNumber(it.simpleName) == day }
            if (dayClass != null) {
                printDay(dayClass)
            } else {
                printError("Day $day not found")
            }
        } else {
            val allDayClasses = getAllDayClasses()
            if (allDayClasses != null) {
                allDayClasses.sortedBy { dayNumber(it.simpleName) }.forEach { printDay(it) }
            } else {
                printError("Couldn't find day classes - make sure you're in the right directory and try building again")
            }
        }
    }

    private fun getAllDayClasses(): MutableSet<Class<out Day>>? {
        var set: MutableSet<Class<out Day>>? = null
        for (i in 1..25) {
            val reflections = Reflections(ConfigurationBuilder().forPackage("day$i"))
            if (set != null) {
                set.addAll(reflections.getSubTypesOf(Day::class.java))
            } else {
                set = reflections.getSubTypesOf(Day::class.java)
            }
        }
        return set
    }

    private fun printDay(dayClass: Class<out Day>) {
        println("\n=== DAY ${dayNumber(dayClass.simpleName)} ===")
        val day = dayClass.constructors[0].newInstance() as Day

        val parsedInput = measureTimedValue { day.parsing() }
        val partOne = measureTimedValue { day.partOne() }
        val partTwo = measureTimedValue { day.partTwo() }
        printParts(parsedInput, partOne, partTwo)
    }

    private fun printParts(parsedInput: TimedValue<*>, partOne: TimedValue<Any>, partTwo: TimedValue<Any>) {
        val padding = max(
            partOne.value.toString().length,
            partTwo.value.toString().length
        ) + 14        // 14 is 8 (length of 'Part 1: ') + 6 more
        println("Part 0: Parsing".padEnd(padding, ' ') + "(${parsedInput.duration})")
        println("Part 1: ${partOne.value}".padEnd(padding, ' ') + "(${partOne.duration})")
        println("Part 2: ${partTwo.value}".padEnd(padding, ' ') + "(${partTwo.duration})")
    }

    private fun printError(message: String) {
        System.err.println("\n=== ERROR ===\n$message")
    }

    private fun dayNumber(dayClassName: String) = dayClassName.replace("Day", "").toInt()
}