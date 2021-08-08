class DaySeven(override val day: Int) : Solve {
    override fun solvePartOne() {
        val rules = readLines("Day7.txt")
        rules.forEach { rule ->
            val ruleSplit = rule.split(" bags contain ")
            val bagColour = ruleSplit[0]
            val dependentBags = ruleSplit[1].split(",")
            print("")
        }
    }

    override fun solvePartTwo() {
    }

}