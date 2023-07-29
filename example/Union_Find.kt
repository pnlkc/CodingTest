// 유니온 파인드 알고리즘은 서로소 집합이라고도 부릅니다
// 유니온 파인드 알고리즘은 노드를 서로 같은 집합으로 묶는 유니온(Union) 기능과
// 노드가 서로 같은 집합에 있는지 확인하는 파인드(Find) 기능을 수행하는 알고리즘입니다
// 최소 신장 트리(MST, Minimum Spanning Tree)를 풀기 위해 반드시 알아야 하는 알고리즘입니다
class Union_Find(n: Int) {
    private val parent = IntArray(n) { it } // 부모 배열은 생성시 자기 자신을 가르키도록 선언합니다
    private val rank = IntArray(n)

    // 최상위 루트 노드를 찾는 메소드입니다
    private fun find(node: Int): Int {
        if (parent[node] != node) {
            return find(parent[node])
        }
        return parent[node]
    }

    // 두 집합을 합치는 메소드입니다
    fun union(node1: Int, node2: Int) {
        val root1 = find(node1)
        val root2 = find(node2)

        if (root1 == root2) return // 이미 같은 집합에 속해 있으므로 return 합니다

        // 두 집합의 랭크를 비교 후 낮은 집합이 높은 집합으로 들어갑니다
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2
        } else {
            // 두 집합의 랭크가 같은 경우 한쪽이 다른 집합에 들어가고, 흡수한 집합은 랭크가 증가합니다
            parent[root2] = root1
            rank[root1]++
        }
    }

    // 두 집합이 같은 집합에 속해 있는지 확인하는 메소드입니다 (필요에 따라 구현해 사용하시면 됩니다)
    fun connected(node1: Int, node2: Int): Boolean {
        return find(node1) == find(node2)
    }
}
