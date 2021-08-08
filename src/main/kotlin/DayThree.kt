class DayThree(override val day: Int) : Solve {

    override fun solvePartOne() {
        val matrix = mutableListOf<MutableList<Char>>()
        val input = readLines("Day3.txt")
        input.forEach { matrix.add(it.toCharArray().toMutableList()) }

        val rowCount = matrix.size
        val columnCount = matrix[0].size

        // printMatrix(matrix)

        var i = 0
        var j = 0
        var treeCount = 0
        while (i < rowCount) {
            if(matrix[i][j % columnCount] == '#') {
                matrix[i][j % columnCount] = 'X'
                treeCount++
            } else {
                matrix[i][j % columnCount] = 'O'
            }
            i += 1
            j += 3
        }

        // printMatrix(matrix)
        println("TreeCount: $treeCount")
    }

    private fun printMatrix(matrix: MutableList<MutableList<Char>>) {
        println()
        println()
        println()
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        matrix.forEach {
            it.forEach { char ->
                print(char)
            }
            println()
        }
    }

    override fun solvePartTwo() {
        val matrix = mutableListOf<MutableList<Char>>()
        val input = readLines("Day3.txt")
        input.forEach { matrix.add(it.toCharArray().toMutableList()) }

        val rowCount = matrix.size
        val columnCount = matrix[0].size

        // printMatrix(matrix)

        val rightList = listOf(1,3,5,7,1)
        val downList  = listOf(1,1,1,1,2)

        var slopeIndex = 0
        val slopes = rightList.map {
            var i = 0
            var j = 0
            var treeCount = 0
            while (i < rowCount) {
                if (matrix[i][j % columnCount] == '#') {
                    treeCount++
                }
                i += downList[slopeIndex]
                j += rightList[slopeIndex]
            }
            slopeIndex++
            treeCount
        }

        // printMatrix(matrix)
        println("Slopes: $slopes")
        println("TreeCount: ${slopes.map { it.toLong() }.reduce { acc, i -> acc * i }}")
    }

}