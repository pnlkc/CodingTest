fun main() {
    val (v, e) = readln().split(' ').map(String::toInt)
    val dist = Array(v) { LongArray(v) }
    var min = Long.MAX_VALUE

    repeat(e) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        dist[a - 1][b - 1] = c.toLong()
    }

    for (k in 0 until v) {
        for (i in 0 until v) {
            for (j in 0 until v) {
                if (i == j || i == k || j == k) continue
                if (dist[i][k] == 0L || dist[k][j] == 0L) continue

                if (dist[i][j] == 0L || dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    for (i in 0 until v - 1) {
        for (j in i + 1 until v) {
            if (dist[i][j] != 0L && dist[j][i] != 0L) min = minOf(min, dist[i][j] + dist[j][i])
        }
    }

    println(if (min == Long.MAX_VALUE) -1 else min)
}