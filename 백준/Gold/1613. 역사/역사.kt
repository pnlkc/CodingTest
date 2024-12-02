fun main() {
    val sb = StringBuilder()
    val (N, K) = readln().split(" ").map { it.toInt() }
    val dist = Array(N + 1) { IntArray(N + 1) }

    for (tc in 1..K) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        dist[a][b] = 1
    }

    for (k in 1..N) {
        for (i in 1..N) {
            for (j in 1..N) {
                if (i == j || j == k || i ==k) continue
                if (dist[i][k] == 0 || dist[k][j] == 0) continue

                if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    val S = readln().toInt()

    for (tc in 1..S) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        sb.appendLine(if (dist[a][b] > 0) -1 else if (dist[b][a] > 0) 1 else 0)
    }

    print(sb)
}