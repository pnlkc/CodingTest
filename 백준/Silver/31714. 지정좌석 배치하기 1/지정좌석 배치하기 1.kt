fun main() {
    val (N, M, D) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j] + D * i
        }

        map[i].sort()
    }

    for (i in 0 until M) {
        for (j in 0 until N - 1) {
            if (map[j][i] >= map[j + 1][i]) {
                println("NO")
                return
            }
        }
    }

    println("YES")
}