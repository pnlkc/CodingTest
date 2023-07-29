// 유니온 파인드 알고리즘은 서로소 집합이라고도 부르며,
// 노드를 서로 같은 집합으로 묶거나 (유니온)
// 노드가 서로 같은 집합에 있는지 확인하는 (파인드) 알고리즘
class Union_Find(n: Int) {
    private val parent = IntArray(n) { it } // 부모 배열은 생성시 자기 자신을 가르키도록 선언
    private val rank = IntArray(n)

    // 최상위 루트 노드를 찾는 메소드
    private fun find(node: Int): Int {
        if (parent[node] != node) {
            return find(parent[node])
        }
        return parent[node]
    }

    // 두 집합을 합치는 메소드
    fun union(node1: Int, node2: Int) {
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
    }

    // 두 집합이 같은 집합에 속해 있는지 확인하는 메소드
    fun connected(node1: Int, node2: Int): Boolean {
        return find(node1) == find(node2)
    }
}
