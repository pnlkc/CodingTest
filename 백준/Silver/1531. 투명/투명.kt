fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(101) { IntArray(101) }
    var cnt = 0

    for (tc in 1..N) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

        for (i in y1..y2) {
            for (j in x1..x2) {
                map[i][j]++
            }
        }
    }

    for (i in 0..100) {
        for (j in 0..100) {
            if (map[i][j] > M) cnt++
        }
    }

    println(cnt)
}