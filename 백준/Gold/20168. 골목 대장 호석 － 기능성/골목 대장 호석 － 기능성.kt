import java.util.LinkedList

data class Node(val a: Int, val b: Int, val d: Int)

fun main() {
    val (N, M, A, B, C) = readln().split(" ").map { it.toInt() }
    val map = Array(N + 1) { mutableListOf<Node>() }

    for (i in 1..M) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }

        map[u].add(Node(u, v, d))
        map[v].add(Node(v, u, d))
    }

    val q = LinkedList<Node>()
    var min = -1
    

    while (q.isNotEmpty()) {
        val (cn, cMax, cd) = q.poll()!!

        if (min != -1 && cMax > min) continue
        if (cn == B) min = if (min == -1) cMax else minOf(min, cMax)

        for ((_, nn, nd) in map[cn]) {
            if (cd + nd > C) continue

            q.add(Node(nn, maxOf(cMax, nd), cd + nd))
        }
    }

    println(min)
}