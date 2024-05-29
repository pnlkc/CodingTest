fun main() {
    val N = readln().toInt()
    val num = 4 * N - 3
    val map = Array(num) { CharArray(num) }
    var m = 0

    for (i in 0 until num) {
        map[i].fill(' ')
    }

    while (2 * m <= num / 2) {
        for (i in (2 * m)..(num - 1 - 2 * m)) {
            map[2 * m][i] = '*'
            map[i][2 * m] = '*'
            map[(num - 1 - 2 * m)][i] = '*'
            map[i][(num - 1 - 2 * m)] = '*'
        }

        m++
    }

    for (i in 0 until num) {
        println(map[i].joinToString(""))
    }
}