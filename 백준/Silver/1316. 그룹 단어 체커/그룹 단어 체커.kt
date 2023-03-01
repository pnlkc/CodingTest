fun main() {
    val testNum = readln().toInt()
    var count = 0

    repeat(testNum) {
        val input = readln()
        val usedList = mutableSetOf<Char>()
        var lastChar = ' '
        var result = true

        for (i in input.indices) {
            if (usedList.contains(input[i]) && input[i] != lastChar) {
                result = false
                break
            }
            usedList.add(input[i])
            lastChar = input[i]
        }

        if (result) count++
    }

    println(count)
}
