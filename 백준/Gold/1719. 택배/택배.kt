fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dist = Array(n) { IntArray(n) }
    val first = Array(n) { IntArray(n) { it + 1 } }

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        if (dist[a - 1][b - 1] == 0) dist[a - 1][b - 1] = c
        else dist[a - 1][b - 1] = minOf(dist[a - 1][b - 1], c)

        if (dist[b - 1][a - 1] == 0) dist[b - 1][a - 1] = c
        else dist[b - 1][a - 1] = minOf(dist[b - 1][a - 1], c)
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || k == i || k == j) continue

                if (dist[i][k] == 0 || dist[k][j] == 0) continue

                if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
                    first[i][j] = first[i][k]
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j != 0) sb.append(" ")
            sb.append(if (i == j) "-" else first[i][j])
        }

        sb.appendLine()
    }

    print(sb)
}