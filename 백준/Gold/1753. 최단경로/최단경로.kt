import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val (v, e) = readln().split(' ').map(String::toInt)
    val k = readln().toInt()
    val graph = Array(v + 1) { mutableMapOf<Int, Int>() }
    val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(v + 1) { -1 }

    pQueue.add(k to 0)
    dist[k] = 0

    repeat(e) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        graph[a][b] = if (graph[a][b] == null) c else minOf(graph[a][b]!!, c)
    }

    while (pQueue.isNotEmpty()) {
        val (cn, cd) = pQueue.poll()!!

        if (dist[cn] != -1 && cd > dist[cn]) continue

        for ((n, d) in graph[cn]) {
            if (dist[n] == -1 || dist[n] > dist[cn] + d) {
                dist[n] = dist[cn] + d
                pQueue.add(n to dist[n])
            }
        }
    }

    for (i in 1..v) {
        sb.appendLine(if (dist[i] == -1) "INF" else dist[i])
    }

    println(sb)
}