fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }
    var cnt = 0

    for (i in 0 until n) {
        val input = readln()

        for (j in 0 until m) {
            map[i][j] = if (input[j] == '0') true else false
        }
    }

    for (j in m - 1 downTo 0) {
        for (i in n - 1 downTo 0) {
            if (map[i][j]) continue

            cnt++

            for (y in 0..i) {
                for (x in 0..j) {
                    map[y][x] = !map[y][x]
                }
            }
        }
    }

    println(cnt)
}