import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n) { listOf<Int>() }
    var target = intArrayOf(-1, -1)
    val dist = Array(n) { IntArray(m) { -1 } }
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(n) {
        val row = readln().split(' ').map(String::toInt)
        graph[it] = row

        for (i in row.indices) {
            if (row[i] == 2) target = intArrayOf(it, i)
            else if (row[i] == 0) dist[it][i] = 0
        }
    }

    dist[target[0]][target[1]] = 0
    queue.add(target[0] to target[1])

    while (queue.isNotEmpty()) {
        val (cy, cx) = queue.poll()!!
        val dy = intArrayOf(1, -1, 0, 0)
        val dx = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val ny = cy + dy[i]
            val nx = cx + dx[i]

            if (ny !in 0 until n || nx !in 0 until m) continue
            if (dist[ny][nx] == 0) continue
            if (dist[ny][nx] == -1 || dist[ny][nx] > dist[cy][cx] + 1) {
                dist[ny][nx] = dist[cy][cx] + 1
                queue.add(ny to nx)
            }
        }
    }

    dist.forEach { sb.appendLine(it.joinToString(" ")) }
    println(sb)
}