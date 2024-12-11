import java.util.PriorityQueue

data class Data(val n: Int, val k: Int)

fun readListInt(): List<Int> = readln().trim().split(" ").map { it.toInt() }

fun main() {
    val (N, M) = readListInt()
    val (s, e) = readListInt()
    val graph = Array(N + 1) { mutableListOf<Data>() }

    repeat(M) {
        val (h1, h2, k) = readListInt()

        graph[h1].add(Data(h2, k))
        graph[h2].add(Data(h1, k))
    }

    val pq = PriorityQueue<Data> { d1, d2 -> d2.k - d1.k }
    val isVisit = BooleanArray(N + 1)
    var min = Int.MAX_VALUE

    isVisit[s] = true
    pq.addAll(graph[s])

    while (pq.isNotEmpty()) {
        val (cn, ck) = pq.poll()!!

        if (!isVisit[cn]) {
            min = minOf(min, ck)
            isVisit[cn] = true
            pq.addAll(graph[cn])

            if (cn == e) break
        }
    }

    println(if (min == Int.MAX_VALUE) 0 else min)
}