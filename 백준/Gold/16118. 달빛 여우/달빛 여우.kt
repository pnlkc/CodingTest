import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Data(val n: Int, val d: Long, val mode: Int = 0) : Comparable<Data> {
    override fun compareTo(other: Data): Int = this.d.compareTo(other.d)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val graph = Array(N + 1) { mutableListOf<Data>() }
    var cnt = 0

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val d = st.nextToken().toLong() * 2

        graph[a].add(Data(b, d))
        graph[b].add(Data(a, d))
    }

    val pq1 = PriorityQueue<Data>()
    val dist1 = LongArray(N + 1) { Long.MAX_VALUE }

    pq1.add(Data(1, 0))
    dist1[1] = 0

    while (pq1.isNotEmpty()) {
        val (cn, cd) = pq1.poll()!!

        if (dist1[cn] < cd) continue

        for ((nn, nd, _) in graph[cn]) {
            if (dist1[nn] > dist1[cn] + nd) {
                dist1[nn] = dist1[cn] + nd
                pq1.add(Data(nn, dist1[nn]))
            }
        }
    }

    val pq2 = PriorityQueue<Data>()
    val dist2 = Array(2) { LongArray(N + 1) { Long.MAX_VALUE } }

    pq2.add(Data(1, 0, 0))
    dist2[0][1] = 0

    while (pq2.isNotEmpty()) {
        val (cn, cd, cm) = pq2.poll()!!

        if (dist2[cm][cn] < cd) continue

        for ((nn, nd) in graph[cn]) {
            val nDist = cd + if (cm == 0) nd / 2 else nd * 2
            val nMode = cm xor 1

            if (dist2[nMode][nn] > nDist) {
                dist2[nMode][nn] = nDist
                pq2.add(Data(nn, nDist, nMode))
            }
        }
    }

    for (i in 1..N) {
        if (dist1[i] < dist2[0][i] && dist1[i] < dist2[1][i]) cnt++
    }

    println(cnt)
}