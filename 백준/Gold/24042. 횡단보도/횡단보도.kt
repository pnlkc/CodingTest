import java.util.PriorityQueue

data class Data(val n: Int, val t: Long) : Comparable<Data> {
    override fun compareTo(other: Data): Int = this.t.compareTo(other.t)
}

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }

    for (i in 1..M) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        graph[a].add(b to i)
        graph[b].add(a to i)
    }

    val pq = PriorityQueue<Data>()
    val time = LongArray(N + 1) { Long.MAX_VALUE  }

    pq.add(Data(1, 0))
    time[1] = 0

    while (pq.isNotEmpty()) {
        val (cn, ct) = pq.poll()!!

        if (cn == N) {
            println(ct)
            return
        }

        if (ct > time[cn]) continue

        for ((nn, ni) in graph[cn]) {
            var div = (ct - ni) / M
            if ((ct - ni) % M != 0L) div++
            if (ct < ni) div = 0
            val minNext = M * div + ni

            if (time[nn] > minNext) {
                time[nn] = minNext
                pq.add(Data(nn, minNext))
            }
        }
    }
}