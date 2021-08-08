import java.util.regex.Pattern

class DaySix(override val day: Int) : Solve {
    override fun solvePartOne() {
        val input = readEntireFile("Day6.txt")
        val answers = input.split(Pattern.compile("\\n[\\n]+"))
        var count = 0
        answers.forEach {
            count += it.replace(Regex("[\n\r]"), "").toSet().size
        }
        print("SUM: $count")

    }

    override fun solvePartTwo() {
        val input = readEntireFile("Day6.txt")
        val answers = input.split(Pattern.compile("\\n[\\n]+"))
        var count = 0
        answers.forEach {
            val persons = it.split("\n")
            val ansFreq = mutableMapOf<Char, Int>()
            persons.forEach { eachPerson ->
                eachPerson.replace(Regex("[\n\r]"), "").toSet().forEach { ans ->
                    ansFreq[ans] = ansFreq.getOrDefault(ans, 0) + 1
                }
            }
            count += ansFreq.filter { it.value == persons.size }.size
        }
        print("SUM : $count")
    }
}