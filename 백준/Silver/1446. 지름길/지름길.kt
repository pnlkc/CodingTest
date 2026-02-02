import java.util.PriorityQueue

fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = mutableMapOf<Int, Int>()
    val set = mutableSetOf(0, d)

    pq.add(0 to 0)
    dist[0] = 0

    repeat(n) {
        val (s, e, l) = readln().split(" ").map { it.toInt() }

        if (graph[s] == null) graph[s] = mutableMapOf()

        val num = if (graph[s]!![e] == null) Int.MAX_VALUE else graph[s]!![e]!!

        graph[s]!![e] = minOf(num, l, e - s)
        set.add(s)
        set.add(e)
    }

    val list = set.toList().sorted()

    for (i in 0 until list.lastIndex) {
        for (j in i + 1..list.lastIndex) {
            val s = list[i]
            val e = list[j]

            if (graph[s] == null) graph[s] = mutableMapOf()

            val num = if (graph[s]!![e] == null) Int.MAX_VALUE else graph[s]!![e]!!

            graph[s]!![e] = minOf(num, e - s)
        }
    }

    while (pq.isNotEmpty()) {
        val (cn, cd) = pq.poll()!!

        if (cn >= d) continue
        if (dist[cn] != -1 && cd > dist[cn]!!) continue
        
        for ((n, d) in graph[cn]!!) {
            if (dist[n] == null || dist[n]!! > dist[cn]!! + d) {
                dist[n] = dist[cn]!! + d
                pq.add(n to dist[n]!!)
            }
        }
    }

    println(dist[d])
}