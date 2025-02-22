import java.util.PriorityQueue

data class Data(val s: Int, val e: Int, val time: Int, val cost: Int)
data class vData(val time: Int, val cost: Int)

fun main() {
    val N = readln().toInt()
    val (T, M) = readln().split(" ").map { it.toInt() }
    val L = readln().toInt()
    val graph = Array(N + 1) { mutableListOf<Data>() }

    for (i in 0 until L) {
        val (s, e, t, c) = readln().split(" ").map { it.toInt() }

        graph[s].add(Data(s, e, t, c))
        graph[e].add(Data(e, s, t, c))
    }

    val pq = PriorityQueue<Data>(compareBy { it.cost })
    val isVisit = Array(N + 1) {
        arrayOf(vData(Int.MAX_VALUE, Int.MAX_VALUE), vData(Int.MAX_VALUE, Int.MAX_VALUE))
    }
    var result = -1

    pq.add(Data(1, 0, 0, 0)) // e는 사용 X
    isVisit[1] = arrayOf(vData(0, 0), vData(0, 0))

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        if (result != -1 && c.cost >= result) continue

        if (c.s == N) {
            result = c.cost
            continue
        }

        for (n in graph[c.s]) {
            if (c.time + n.time > T || c.cost + n.cost > M) continue

            if (isVisit[n.e][1].time > c.time + n.time || isVisit[n.e][0].cost > c.cost + n.cost) {
                if (isVisit[n.e][0].time > c.time + n.time) isVisit[n.e][0] = vData(c.time + n.time, c.cost + n.cost)
                if (isVisit[n.e][1].cost > c.cost + n.cost) isVisit[n.e][1] = vData(c.time + n.time, c.cost + n.cost)

                pq.add(Data(n.e, 0, c.time + n.time, c.cost + n.cost))
            }
        }
    }

    println(result)
}