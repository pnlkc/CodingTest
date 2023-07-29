import java.util.PriorityQueue

class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n)
    var result = 0
    var cnt = 0

    // 최상위 루트 노드를 찾는 메소드
    private fun find(node: Int): Int {
        if (parent[node] != node) {
            return find(parent[node])
        }
        return parent[node]
    }

    // 두 집합을 합치는 메소드
    fun union(node1: Int, node2: Int, num: Int) {
        val root1 = find(node1)
        val root2 = find(node2)

        if (root1 == root2) return // 이미 같은 집합에 속해 있으므로 return

        // 두 집합의 랭크를 비교 후 낮은 집합이 높은 집합으로 들어감
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2
        } else {
            // 두 집합의 랭크가 같은 경우 둘 중 아무나 다른 집합에 들어가고 흡수한 집합은 랭크를 1 증가함
            parent[root2] = root1
            rank[root1]++
        }

        result += num
        cnt++
    }
}

fun main() {
    val (v, e) = readln().split(" ").map(String::toInt)
    val pq = PriorityQueue<IntArray> { arr1, arr2 -> arr1[2] - arr2[2] }

    repeat(e) {
        val (a, b, c) = readln().split(" ").map(String::toInt)
        pq.add(intArrayOf(a - 1, b - 1, c))
    }

    val uf = UnionFind(v)

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!
        uf.union(c[0], c[1], c[2])
        if (uf.cnt == v - 1) break
    }

    println(uf.result)
}