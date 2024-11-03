data class Data(val x: Int, val y: Int, val r: Int)

var result = 0

fun main() {
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        result = N
        val parent = IntArray(N) { it }
        val rank = IntArray(N) { it }
        val graph = Array(N) { Data(-1, -1, -1) }

        for (i in 0 until N) {
            val (x, y, R) = readln().split(" ").map { it.toInt() }
            graph[i] = Data(x, y, R)
        }

        for (i in 0 until N - 1) {
            for (j in i + 1 until N) {
                val range = (graph[i].r + graph[j].r) * (graph[i].r + graph[j].r)
                
                if (calcDist(graph[i], graph[j]) <= range) {
                    union(i, j, parent, rank)
                }
            }
        }

        println(result)
    }
}

fun find(node: Int, parent: IntArray, rank: IntArray): Int {
    if (parent[node] != node) {
        parent[node] = find(parent[node], parent, rank)
        return parent[node]
    }
    return parent[node]
}

fun union(node1: Int, node2: Int, parent: IntArray, rank: IntArray) {
    val root1 = find(node1, parent, rank)
    val root2 = find(node2, parent, rank)

    if (root1 == root2) return

    result--

    if (rank[root1] > rank[root2]) {
        parent[root2] = root1
    } else if (rank[root1] < rank[root2]) {
        parent[root1] = root2
    } else {
        parent[root2] = root1
        rank[root1]++
    }
}

fun calcDist(d1: Data, d2: Data): Int {
    return (d1.x - d2.x) * (d1.x - d2. x) + (d1.y - d2.y) * (d1.y - d2.y)
}