import java.util.PriorityQueue

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Pair<Int, Int>>>(N + 1) { mutableListOf() }

    (1..M).forEach { _ ->
        val (A, B, C) = readln().split(" ").map { it.toInt() }
        graph[A].add(B to C)
        graph[B].add(A to C)
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(N + 1) { Int.MAX_VALUE }

    pq.add(1 to 0)
    dist[1] = 0

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        if (dist[c.first] < c.second) continue

        for ((nn, nd) in graph[c.first]) {
            if (dist[nn] > c.second + nd) {
                dist[nn] = c.second + nd
                pq.add(nn to dist[nn])
            }
        }
    }

    println(dist[N])
}