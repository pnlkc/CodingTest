fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val m = readln().toInt()
    val dist = Array(n) { IntArray(n) }
    val path = Array(n) { Array(n) { mutableListOf<Int>() } }

    repeat(m) {
        val (a, b, c) = readln().split(' ').map(String::toInt)

        if (dist[a - 1][b - 1] == 0) {
            dist[a - 1][b - 1] = c
            path[a - 1][b - 1] = mutableListOf(a)
        } else {
            dist[a - 1][b - 1] = minOf(dist[a - 1][b - 1], c)
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || i == k || j == k) continue
                if (dist[i][k] == 0 || dist[k][j] == 0) continue

                if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                    path[i][j] = (path[i][k] + path[k][j]).toMutableList()
                }
            }
        }
    }

    dist.forEach { sb.appendLine(it.joinToString(" ")) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (path[i][j].size == 0) sb.appendLine(0)
            else {
                sb
                    .append("${path[i][j].size + 1} ")
                    .append(path[i][j].joinToString(" "))
                    .append(" ${j + 1}\n")
            }
        }
    }

    println(sb)
}