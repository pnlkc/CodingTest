import java.util.PriorityQueue

data class Data(val a: Int, val b: Int, val d: Int)

var p = intArrayOf()
var r = intArrayOf()
var sum = 0L
var cnt = 0

fun main() {
    val (N, M, K) = splitToLong()
    val n = N.toInt()
    val m = M.toInt()
    val sArr = splitToInt()
    val pq = PriorityQueue<Data> { d1, d2 -> d1.d - d2.d }
    val isDisconnected = BooleanArray(n + 1)

    if (M <= 1) {
        println("YES")
        return
    }

    for (i in 1 until n) {
        pq.add(Data(i, i + 1, 0))
    }

    pq.add(Data(n, 1, 0))

    sArr.forEachIndexed { idx, i ->
        pq.add(Data(0, idx + 1, i))
    }

    repeat(m) {
        val (i, j) = splitToInt()

        if (minOf(i, j) == 1 && maxOf(i, j ) == n) {
            isDisconnected[n] = true
        } else {
            isDisconnected[minOf(i, j)] = true
        }
        
    }

    p = IntArray(n + 1) { it }
    r = IntArray(n + 1)

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        if (isDisconnected[c.a]) continue

        union(c.a, c.b, c.d)
        if (cnt == n) break
    }

    println(if (cnt == n && sum <= K) "YES" else "NO")
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

    sum += num
    cnt++
}

fun splitToInt() = readln().split(" ").map { it.toInt() }
fun splitToLong() = readln().split(" ").map { it.toLong() }
