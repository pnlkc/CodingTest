import java.util.PriorityQueue

data class Data(val a: Int, val b: Int, val c: Int)

var p = intArrayOf()
var r = intArrayOf()
var result = 0
var cnt = 0

fun getInput() = readln().split(" ").map { it.toInt() }

fun main() {
    val (N, M, t) = getInput()
    val pq = PriorityQueue<Data> { d1, d2 -> d1.c - d2.c }

    p = IntArray(N + 1) { it }
    r = IntArray(N +  1)

    repeat(M) {
        val (A, B, C) = getInput()

        pq.add(Data(A, B, C))
    }

    while (pq.isNotEmpty()) {
        val (ca, cb, cc) = pq.poll()!!
        union(ca, cb, cc, t)
        if (cnt == N - 1) break
    }

    println(result)
}

fun find(n: Int): Int {
    if (p[n] != n) p[n] = find(p[n])
    return p[n]
}

fun union(n1: Int, n2: Int, d: Int, t: Int) {
    val r1 = find(n1)
    val r2 = find(n2)

    if (r1 == r2) return

    when {
        r[r1] > r[r2] -> p[r2] = r1
        r[r1] < r[r2] -> p[r1] = r2
        else -> {
            p[r1] = r2
            r[r2]++
        }
    }

    result += d + t * cnt++
}