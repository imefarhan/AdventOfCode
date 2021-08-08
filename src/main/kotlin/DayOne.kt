class DayOne(override val day: Int) : Solve {

    override fun solvePartOne() {
        try {
            val targetSum = 2020
            val set = mutableSetOf<Int>()
            val input = readLines("Day1.txt").map { it.toInt() }
            for (value in input) {
                val requiredVal = targetSum - value
                if (set.contains(requiredVal)) {
                    println("Found Pair: $value + $requiredVal = $targetSum")
                    println("Result: $value * $requiredVal = ${value * requiredVal}")
                    break
                } else {
                    set.add(value)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun solvePartTwo() {
        val targetSum = 2020
        val input = readLines("Day1.txt").map { it.toInt() }.sorted()
        input.forEachIndexed { i, _ ->
            var l = i+1
            var r = input.size-1
            while (l<r) {
                val currentSum = input[i] + input[l] + input[r]
                if (currentSum == targetSum) {
                    println("Triplets Found: ${input[i]} + ${input[l]} + ${input[r]} = $targetSum")
                    print("Product: ${input[i]} * ${input[l]} * ${input[r]} = ${input[i] * input[l] * input[r]}")
                    break
                } else if (currentSum > targetSum) {
                    r--
                } else {
                    l++
                }
            }
        }
    }

}