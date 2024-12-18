fun main() {
    val N = readln().toInt()
    val size = 2 * N
    val map = Array(size - 1) { CharArray(size) { ' ' } }

    for (i in 1..N) {
        for (j in 0 until i) {
            map[i - 1][j] = '*'
            map[i - 1][size - 1 - j] = '*'
            map[size - 1 - i][j] = '*'
            map[size - 1 - i][size - 1 - j] = '*'
        }
    }

    for (i in 0 until size - 1) {
        println(map[i].joinToString(""))
    }
}