import java.util.PriorityQueue

data class Data(val a: Int, val b: Int, val d: Int)

var p = intArrayOf()
var r = intArrayOf()
var result = 0L
var cnt = 0

fun main() {
    val (N, M) = splitToInt()
    val pq = PriorityQueue<Data> { d1, d2 -> d1.d - d2.d }
    var sum = 0L

    for (i in 1..M) {
        val (a, b, c) = splitToInt()

        pq.add(Data(a, b, c))
        sum += c
    }

    p = IntArray(N + 1) { it }
    r = IntArray(N + 1)

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        union(c.a, c.b, c.d)
        if (cnt == N - 1) break
    }
    
    println(if (cnt < N - 1) -1 else sum - result)
}

fun find(node: Int): Int {
    if (p[node] != node) p[node] = find(p[node])
    return p[node]
}

fun union(n1: Int, n2: Int, num: Int) {
    val r1 = find(n1)
    val r2 = find(n2)

    if (r1 == r2) return

    when {
        r[r1] > r[r2] -> p[r2] = r1
        r[r1] < r[r2] -> p[r1] = r2
        else -> {
            p[r2] = r1
            r[r1]++
        }
    }

    result += num
    cnt++
}

fun splitToInt() = readln().split(" ").map { it.toInt() }