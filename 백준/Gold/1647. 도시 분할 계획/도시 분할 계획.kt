import java.util.PriorityQueue

var cnt = 0
var answer = 0
var maxd = 0

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val parent = IntArray(n) { it }
    val rank = IntArray(n)
    val pq = PriorityQueue<Triple<Int, Int, Int>> { p1, p2 -> p1.third - p2.third }

    repeat(m) {
        val (a, b, c) = readln().split(" ").map(String::toInt)
        pq.add(Triple(a - 1, b - 1, c))
    }

    while (pq.isNotEmpty()) {
        val (ca, cb, cc) = pq.poll()!!
        union(ca, cb, parent, rank, cc)
        if (cnt == n - 1) break
    }

    println(answer - maxd)
}

fun union(node1: Int, node2: Int, parent: IntArray, rank: IntArray, d: Int) {
    val p1 = find(node1, parent)
    val p2 = find(node2, parent)

    if (p1 == p2) return
    if (rank[p1] < rank[p2]) {
        parent[p1] = p2
    } else if (rank[p1] > rank[p2]) {
        parent[p2] = p1
    } else {
        parent[p2] = p1
        rank[p1]++
    }

    maxd = maxOf(d, maxd)
    answer += d
    cnt++
}

fun find(node: Int, parent: IntArray): Int {
    if (node != parent[node]) {
        return find(parent[node], parent)
    }
    return parent[node]
}