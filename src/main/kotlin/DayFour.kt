import java.util.regex.Pattern

class DayFour(override val day: Int) : Solve {

    override fun solvePartOne() {
        val input = readEntireFile("Day4.txt")
        val passports = input.split(Pattern.compile("\\n[\\n]+")).map {
            containsAllRequiredFields(it)
        }
        println("Valid Passports: $passports")
        println("Valid Passports Count: ${passports.count { it }}")
    }

    private fun containsAllRequiredFields(passport: String): Boolean {
        val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
        requiredFields.forEach {
            if(!passport.contains(it)) return false
        }
        return true
    }

    override fun solvePartTwo() {
        val input = readEntireFile("Day4.txt")
        var validCount = 0
        input.split(Pattern.compile("\\n[\\n]+")).forEach {
            if (containsAllRequiredFields(it)) {
                if (performDataValidation(it)) {
                    validCount++
                }
            }
        }
        println("Valid Passports Count: $validCount")
    }

    private fun performDataValidation(passport: String): Boolean {

        val fieldMap = passport.split(" ", "\n").associate {
            val keyValuePair = it.split(":")
            keyValuePair[0] to keyValuePair[1]
        }

        try {
            fieldMap["byr"]?.let {
                if (!validateYears(it, 1920, 2002)) {
                    println("false because of byr = $it")
                    return false
                }
            } ?: return false

            fieldMap["iyr"]?.let {
                if (!validateYears(it, 2010, 2020)) {
                    println("false because of iyr = $it")
                    return false
                }
            } ?: return false

            fieldMap["eyr"]?.let {
                if (!validateYears(it, 2020, 2030)) {
                    println("false because of eyr = $it")
                    return false
                }
            } ?: return false

            fieldMap["hgt"]?.let {
                when {
                    it.endsWith("cm") -> {
                        val heightNum = it.substringBefore("cm").toInt()
                        if (heightNum !in 150..193) {
                            println("false because of hgt = $it")
                            return false
                        }
                    }
                    it.endsWith("in") -> {
                        val heightNum = it.substringBefore("in").toInt()
                        if (heightNum !in 59..76) {
                            println("false because of hgt = $it")
                            return false
                        }
                    }
                    else -> {
                        println("false because of hgt = $it")
                        return false
                    }
                }
            } ?: return false

            fieldMap["hcl"]?.let {
                if(!it.startsWith("#")) {
                    println("false because of hcl = $it doesn't start's with #")
                    return false
                }
                if (it.substringAfter("#").toCharArray().any { char ->
                        print("")
                        char !in listOf('a', 'b', 'c', 'd', 'e', 'f',
                            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
                }) {
                    println("false because of hcl = $it contains invalid chars")
                    return false
                }
            }

            fieldMap["ecl"]?.let {
                if (it !in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) {
                    println("false because of ecl = $it not in valid list")
                    return false
                }
            }

            fieldMap["pid"]?.let {
                if (it.length != 9) {
                    println("false because of pid = $it, length > 9")
                    return false
                }
                if (!isNumber(it)) {
                    println("false because of pid = $it, is not a number")
                    return false
                }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }

    private fun validateYears(year: String, startYear: Int, endYear: Int): Boolean {
        if(year.length != 4) {
            return false
        }
        if(year.toInt() !in startYear..endYear) {
            return false
        }
        return true
    }

    private fun isNumber(value: String): Boolean {
        return try {
            value.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }

}