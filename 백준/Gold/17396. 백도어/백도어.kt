import java.util.PriorityQueue

data class Node(val n: Int, val t: Long)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val sightList = readln().split(" ").map { it.toInt() }
    val graph = Array(N) { mutableListOf<Node>() }

    for (i in 0 until M) {
        val (a, b, t) = readln().split(" ").map { it.toInt() }
        graph[a].add(Node(b, t.toLong()))
        graph[b].add(Node(a, t.toLong()))
    }

    val pq = PriorityQueue<Node>(compareBy { it.t })
    val dist = LongArray(N) { -1L }

    pq.offer(Node(0, 0))
    dist[0] = 0

    while (pq.isNotEmpty()) {
        val (cn, ct) = pq.poll()!!

        if (cn == N - 1) continue
        if (dist[cn] != -1L && dist[cn] < ct) continue

        for ((nn, nt) in graph[cn]) {
            if (nn != N - 1 && sightList[nn] == 1) continue
            if (dist[nn] != -1L && dist[nn] <= ct + nt) continue

            dist[nn] = ct + nt
            pq.offer(Node(nn, dist[nn]))
        }
    }

    println(dist[N - 1])
}