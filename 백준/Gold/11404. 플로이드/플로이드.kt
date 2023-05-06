import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bw = BufferedReader(InputStreamReader(System.`in`))
    val n = bw.readLine().toInt()
    val m = bw.readLine().toInt()
    val dist = Array(n) { LongArray(n) }

    repeat(m) {
        val (a, b, c) = bw.readLine().split(' ').map(String::toInt)

        if (dist[a - 1][b - 1] == 0L) dist[a - 1][b - 1] = c.toLong()
        else dist[a - 1][b - 1] = minOf(dist[a - 1][b - 1], c.toLong())
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || k == i || k == j) continue
                if (dist[i][k] == 0L || dist[k][j] == 0L) continue

                if (dist[i][j] == 0L || dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    dist.forEach { println(it.joinToString(" ")) }
}