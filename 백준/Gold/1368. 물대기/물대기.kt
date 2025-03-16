import java.util.PriorityQueue

data class Node(val u: Int, val v: Int, val d: Int)

var parent = intArrayOf()
var rank = intArrayOf()
var cnt = 0
var result = 0

fun main() {
    val N = readln().toInt()
    val pq = PriorityQueue<Node> { n1, n2 -> n1.d - n2.d }

    parent = IntArray(N + 1) { it }
    rank = IntArray(N + 1)

    for (i in 1..N) {
        val num = readln().toInt()
        pq.add(Node(0, i, num))
        pq.add(Node(i, 0, num))
    }

    for (i in 1..N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 1..N) {
            pq.add(Node(i, j, input[j - 1]))
            pq.add(Node(j, i, input[j - 1]))
        }
    }

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        union(c.u, c.v, c.d)
        if (cnt == N) break
    }

    println(result)
}

fun find(node: Int): Int {
    if (parent[node] != node) parent[node] = find(parent[node])

    return parent[node]
}

fun union(node1: Int, node2: Int, num: Int) {
    val root1 = find(node1)
    val root2 = find(node2)

    if (root1 == root2) return

    when {
        rank[root1] > rank[root2] -> parent[root2] = root1
        rank[root1] < rank[root2] -> parent[root1] = root2
        else -> {
            parent[root2] = root1
            rank[root1]++
        }
    }

    result += num
    cnt++
}