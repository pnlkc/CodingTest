import java.util.PriorityQueue

data class Data(val a: Int, val b: Int, val c: Int)

var p = intArrayOf()
var r = intArrayOf()
var result = 0
var cnt = 0

fun getInput() = readln().split(" ").map { it.toInt() }

fun main() {
    val (N, M, K) = getInput()
    val pq = PriorityQueue<Data> { d1, d2 -> d1.c - d2.c }
    val list = getInput()

    p = IntArray(N + 1) { it }
    r = IntArray(N + 1)
    cnt = K

    list.forEach { num -> p[num] = 0 }

    repeat(M) {
        val (u, v, w) = getInput()

        pq.add(Data(u, v, w))
    }

    while (pq.isNotEmpty()) {
        val (ca, cb, cc) = pq.poll()!!
        union(ca, cb, cc)
        if (cnt == N - 1) break
    }

    println(result)
}

fun find(n: Int): Int {
    if (p[n] != n && p[n] != 0) p[n] = find(p[n])
    return p[n]
}

fun union(n1: Int, n2: Int, d: Int) {
    val r1 = find(n1)
    val r2 = find(n2)

    if (r1 == r2) return
    if (r1 == 0) p[r2] = 0 else p[r1] = r2

    result += d
}