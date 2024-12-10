import java.util.PriorityQueue

data class Data(val u: Int, val v: Int, val d: Int)

var p = intArrayOf()
var r = intArrayOf()
var result = 0
var cnt = 0

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ")
    val pq = PriorityQueue<Data> { d1, d2 -> d1.d - d2.d }
    p = IntArray(N + 1) { it }
    r = IntArray(N + 1)

    repeat(M) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }
        if (arr[u - 1] != arr[v - 1]) pq.add(Data(u, v, d))
    }

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!
        union(c)

        if (cnt == N - 1) break
    }

    println(if (cnt != N - 1) -1 else result)
}

private fun find(node: Int): Int {
    if (p[node] != node) p[node] = find(p[node])
    return p[node]
}

fun union(data: Data) {
    val r1 = find(data.u)
    val r2 = find(data.v)

    if (r1 == r2) return
    
    when {
        r[r1] > r[r2] -> p[r2] = r1
        r[r1] < r[r2] -> p[r1] = r2
        else -> {
            p[r2] = r1
            r[r1]++
        }
    }

    result += data.d
    cnt++
}