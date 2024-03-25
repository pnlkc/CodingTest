fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    var result = 1

    for (i in 0 until N) {
        val str = readln()

        for (j in 0 until M) {
            map[i][j] = str[j].digitToInt()
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            for (k in 1..maxOf(N, M)) {
                if (i + k >= N || j + k >= M) continue
                if (k < result - 1) continue

                val set = mutableSetOf<Int>()
                set.apply {
                    add(map[i][j])
                    add(map[i][j + k])
                    add(map[i + k][j])
                    add(map[i + k][j + k])
                }

                if (set.size == 1) {
                    result = maxOf(result, k + 1)
                }
            }
        }
    }

    println(result * result)
}