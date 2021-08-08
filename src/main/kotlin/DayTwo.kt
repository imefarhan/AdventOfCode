class DayTwo(override val day: Int) : Solve {

    override fun solvePartOne() {
        val input = readLines("Day2.txt")
        var validCount = 0
        input.forEach {
            val password = it.substringAfter(":").trim()
            val rules = it.substringBefore(":").trim()
            val ruleRange = rules.substringBefore(" ")
            val ruleChar = rules.substringAfter(" ").trim()[0]
            val min = ruleRange.substringBefore("-").toInt()
            val max = ruleRange.substringAfter("-").toInt()
            val count = password.count { it == ruleChar }
            if (count in min..max) validCount++
            print("")
        }
        println("Valid Counts: $validCount")
    }

    override fun solvePartTwo() {
        val input = readLines("Day2.txt")
        var validCount = 0
        input.forEach {
            val password = it.substringAfter(":").trim()
            val rules = it.substringBefore(":").trim()
            val ruleRange = rules.substringBefore(" ")
            val ruleChar = rules.substringAfter(" ").trim()[0]
            val indexOne = ruleRange.substringBefore("-").toInt() - 1
            val indexTwo = ruleRange.substringAfter("-").toInt() - 1
            if (
                (password[indexOne] == ruleChar && password[indexTwo] != ruleChar) ||
                (password[indexTwo] == ruleChar && password[indexOne] != ruleChar)
            ) {
                validCount++
            }
        }
        print("Valid Counts: $validCount")
    }

}