import java.util.PriorityQueue

data class Node(val a: Int, val b: Int, val d: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.d - other.d
}

fun main() {
    val (N, M, A, B, C) = readln().split(" ").map { it.toInt() }
    val map = Array(N + 1) { mutableListOf<Node>() }

    for (i in 1..M) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }

        map[u].add(Node(u, v, d))
        map[v].add(Node(v, u, d))
    }

    val pq = PriorityQueue<Node>()
    var min = -1
    val dist = Array(N + 1) { Int.MAX_VALUE to Int.MAX_VALUE }

    pq.add(Node(A, 0, 0))
    dist[A] = 0 to 0

    while (pq.isNotEmpty()) {
        val (cn, cMax, cd) = pq.poll()!!

        if (min != -1 && cMax >= min) continue
        if (cn == B) min = if (min == -1) cMax else minOf(min, cMax)

        for ((_, nn, nd) in map[cn]) {
            if (cd + nd > C) continue
            if (dist[nn].first <= maxOf(cMax, nd) && dist[nn].second <= cd + nd) continue

            if (dist[nn].first > maxOf(cMax, nd) && dist[nn].second > cd + nd) dist[nn] = maxOf(cMax, nd) to cd + nd

            pq.add(Node(nn, maxOf(cMax, nd), cd + nd))
        }
    }

    println(min)
}