import java.util.PriorityQueue

data class Node(val n: Int, val d: Long)

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Node>() }
    val result = LongArray(N + 1) { Long.MAX_VALUE }

    for (i in 0 until M) {
        val (u, v, c) = readln().split(" ").map { it.toInt() }

        graph[v].add(Node(u, c.toLong()))
    }

    val kL = readln().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Node>(compareBy { it.d })
    val dist = LongArray(N + 1) { -1L }

    for (k in kL) {
        pq.add(Node(k, 0))
        dist[k] = 0
    }

    while (pq.isNotEmpty()) {
        val (cn, cd) = pq.poll()!!

        if (dist[cn] != -1L && cd > dist[cn]) continue

        for ((n, d) in graph[cn]) {
            if (dist[n] == -1L || dist[n] > dist[cn] + d) {
                dist[n] = dist[cn] + d
                pq.add(Node(n, dist[n]))
            }
        }
    }

    for (i in 1..N) {
        if (dist[i] != -1L && dist[i] < result[i]) {
            result[i] = dist[i]
        }
    }

    var maxNum = 0
    var max = 0L

    for (i in 1..N) {
        if (result[i] != Long.MAX_VALUE && result[i] > max) {
            maxNum = i
            max = result[i]
        }
    }

    println(maxNum)
    println(max)
}