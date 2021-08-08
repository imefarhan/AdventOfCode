class DayFive(override val day: Int) : Solve {
    override fun solvePartOne() {
        val boardingPasses = readLines("Day5.txt")
        var maxSeatId = Int.MIN_VALUE
        boardingPasses.forEach {
            val rowPattern = it.substring(0, 7)
            val colPattern = it.substring(7, it.length)
            val rowId = getIdFromPattern(rowPattern, 0..127, 0)
            val colId = getIdFromPattern(colPattern, 0..7, 0)
            val seatId = rowId * 8 + colId
            maxSeatId = maxOf(maxSeatId, seatId)
            println("ColId: $colId, RowId: $rowId, SeatId = $seatId")
        }
        println("Max Seat Id: $maxSeatId")
    }

    private fun getIdFromPattern(rowPattern: String, rowRange: IntRange, index: Int): Int {
        val mean = (rowRange.first + rowRange.last)/2
        return when {
            index == rowPattern.length -> mean
            rowPattern[index] == 'F' -> getIdFromPattern(rowPattern, rowRange.first..mean, index+1)
            rowPattern[index] == 'B' -> getIdFromPattern(rowPattern, mean+1..rowRange.last, index+1)
            rowPattern[index] == 'L' -> getIdFromPattern(rowPattern, rowRange.first..mean, index+1)
            rowPattern[index] == 'R' -> getIdFromPattern(rowPattern, mean+1..rowRange.last, index+1)
            else -> mean
        }
    }

    override fun solvePartTwo() {
        val boardingPasses = readLines("Day5.txt")
        var maxSeatId = Int.MIN_VALUE
        val sortedSeatIds = boardingPasses.map {
            val rowPattern = it.substring(0, 7)
            val colPattern = it.substring(7, it.length)
            val rowId = getIdFromPattern(rowPattern, 0..127, 0)
            val colId = getIdFromPattern(colPattern, 0..7, 0)
            val seatId = rowId * 8 + colId
            maxSeatId = maxOf(maxSeatId, seatId)
            println("ColId: $colId, RowId: $rowId, SeatId = $seatId")
            seatId
        }.sorted()
        val standardDiff = sortedSeatIds[0]
        var index = 0
        var mySeatId = Int.MIN_VALUE
        // Finding the first missing number in a series
        for (value in sortedSeatIds) {
            if (value - index != standardDiff) {
                mySeatId = value - 1
                break
            }
            index++
        }
        println("SeatIds: ${sortedSeatIds.sorted()}")
        println("My Seat Id: $mySeatId")
    }
}