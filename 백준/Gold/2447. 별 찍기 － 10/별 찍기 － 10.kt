var array = arrayOf<CharArray>()

fun main() {
    val num = readln().toInt()
    array = Array(num) { CharArray(num) { '*' } }
    controlArray(0 to num - 1, 0 to num - 1, num)
    println(array.joinToString("") { it.joinToString("") + "\n" })
}

fun controlArray(xRange: Pair<Int, Int>, yRange: Pair<Int, Int>, num: Int) {
    val range = num / 3
    val xList = arrayOf(
        xRange.first to xRange.first + range - 1,
        xRange.first + range to xRange.first + range * 2 - 1,
        xRange.first + range * 2 to  xRange.first + range * 3 - 1
    )
    val yList = arrayOf(
        yRange.first to yRange.first + range - 1,
        yRange.first + range to yRange.first + range * 2 - 1,
        yRange.first + range * 2 to yRange.first + range * 3 - 1)

    for (i in yList.indices) {
        for (j in xList.indices) {
            if (i == 1 && j == 1) controlCenter(yList[i], xList[j])
            else if (range > 1) controlArray(yList[i], xList[j], range)
        }
    }
}

fun controlCenter(yRange: Pair<Int, Int>, xRange: Pair<Int, Int>) {
    for (i in yRange.first..yRange.second) {
        for (j in xRange.first..xRange.second) {
            array[i][j] = ' '
        }
    }
}