fun main(args: Array<String>) {
    solveDailyProblem(DayOne(1))
    solveDailyProblem(DayTwo(2))
    solveDailyProblem(DayThree(3))
    solveDailyProblem(DayFour(4))
    solveDailyProblem(DayFive(5))
    solveDailyProblem(DaySix(6))
    solveDailyProblem(DaySeven(7))
}

fun solveDailyProblem(day: Solve) {
    println("----------------------Day-${day.day} Starts--------------------")
    day.solvePartOne()
    day.solvePartTwo()
    println()
    println("----------------------Day-${day.day} Ends----------------------")
}