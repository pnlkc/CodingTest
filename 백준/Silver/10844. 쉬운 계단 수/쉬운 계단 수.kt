fun main() {
    val num = readln().toInt()
    val array = Array(num) {
        mutableMapOf(0 to 0, 1 to 1, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1, 7 to 1, 8 to 1, 9 to 1)
    }

    for (i in 1 until num) {
        array[i][0] = array[i - 1][1]!!
        array[i][1] = (array[i - 1][0]!! + array[i - 1][2]!!) % 1_000_000_000
        array[i][2] = (array[i - 1][1]!! + array[i - 1][3]!!) % 1_000_000_000
        array[i][3] = (array[i - 1][2]!! + array[i - 1][4]!!) % 1_000_000_000
        array[i][4] = (array[i - 1][3]!! + array[i - 1][5]!!) % 1_000_000_000
        array[i][5] = (array[i - 1][4]!! + array[i - 1][6]!!) % 1_000_000_000
        array[i][6] = (array[i - 1][5]!! + array[i - 1][7]!!) % 1_000_000_000
        array[i][7] = (array[i - 1][6]!! + array[i - 1][8]!!) % 1_000_000_000
        array[i][8] = (array[i - 1][7]!! + array[i - 1][9]!!) % 1_000_000_000
        array[i][9] = (array[i - 1][8]!!)
    }

    println(array[num - 1].values.sumOf { it.toLong() } % 1_000_000_000)
}