import java.io.File

private const val RESOURCE_PATH = "src/main/resources"

fun getReader(filename: String) = File("$RESOURCE_PATH/$filename").bufferedReader()

fun readLines(filename: String) = File("$RESOURCE_PATH/$filename").bufferedReader().readLines()

fun readEntireFile(filename: String) = File("$RESOURCE_PATH/$filename").readText(Charsets.UTF_8)

interface Solve {
    val day: Int
    fun solvePartOne()
    fun solvePartTwo()
}