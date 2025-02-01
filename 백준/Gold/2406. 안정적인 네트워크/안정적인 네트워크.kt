import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val u: Int, val v: Int, val d: Int)

val sb = StringBuilder()
var parent = intArrayOf()
var rank = intArrayOf()
var sum = 0
var result = 0
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val pq = PriorityQueue<Node>(compareBy { it.d })

    parent = IntArray(n) { it }
    rank = IntArray(n)

    repeat(m) {
        val edge = StringTokenizer(br.readLine())
        val a = edge.nextToken().toInt() - 1
        val b = edge.nextToken().toInt() - 1

        union(a, b, 0)
    }

    repeat(n) { i ->
        val st2 = StringTokenizer(br.readLine())

        for (j in 0 until n) {
            val num = st2.nextToken().toInt()
            if (i == 0 || j == 0 || i == j) continue

            pq.add(Node(i, j, num))
        }
    }

    while (pq.isNotEmpty()) {
        val c = pq.poll()

        union(c.u, c.v, c.d)
        if (cnt == n - 2) break
    }

    println("$sum $result")
    print(sb)
}

fun find(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = find(parent[node])
    }
    return parent[node]
}

fun union(node1: Int, node2: Int, num: Int) {
    val root1 = find(node1)
    val root2 = find(node2)

    if (root1 == root2) return

    if (rank[root1] > rank[root2]) {
        parent[root2] = root1
    } else if (rank[root1] < rank[root2]) {
        parent[root1] = root2
    } else {
        parent[root2] = root1
        rank[root1]++
    }

    sum += num
    cnt++

    if (num != 0) {
        result++
        sb.appendLine("${node1 + 1} ${node2 + 1}")
    }
}