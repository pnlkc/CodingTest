fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() - 1 }
        val uf = UnionFind(n)

        for (i in 0 until n) {
            uf.union(i, list[i])
        }

        val set = mutableSetOf<Int>()

        for (i in 0 until n) {
            set.add(uf.find(i))
        }

        sb.appendLine(set.size)
    }

    print(sb)
}

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n)

    fun find(node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent[node])
            return parent[node]
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
    }
}