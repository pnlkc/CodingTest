fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    repeat(T) {
        val (n, seed, a, b) = readln().split(" ").map { it.toLong() }
        val mod = (n * n).toInt()
        val visited = BooleanArray(mod)
        var e = (seed % (n * n)).toInt()
        var result = 1
        val uf = UnionFind(n.toInt())

        while (true) {
            if (visited[e]) {
                result = 0
                break
            }
            
            visited[e] = true

            val x = e / n.toInt()
            val y = e % n.toInt()

            if (x != y && !uf.isConnected(x, y)) {
                uf.union(x, y)
                if (uf.cnt == n.toInt() - 1) break
            }

            result++
            e = (((e.toLong() * a) + b) % (n * n)).toInt()
        }

        sb.appendLine(result)
    }

    print(sb)
}

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n)
    var cnt = 0

    private fun find(node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent[node])
        }
        return parent[node]
    }

    fun union(node1: Int, node2: Int) {
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
        cnt++
    }

    fun isConnected(node1: Int, node2: Int): Boolean {
        return find(node1) == find(node2)
    }
}