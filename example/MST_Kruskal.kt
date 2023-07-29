import java.util.PriorityQueue

/**
 * 최소 신장 트리(Minimum Spanning Tree, MST)는
 * 모든 노드가 서로 연결된 순환하지 않는 트리 중
 * 가중치의 합이 최소가 되는 트리를 의미합니다
 *
 * 크루스칼(Kruskal) 알고리즘은 최소 신장 트리 문제를 풀 때 사용하는 알고리즘 중 하나입니다
 * 그리디 알고리즘으로 분류가 되며,
 * 진행과정은 아래와 같습니다
 * 1. 간선을 가중치가 작은 것부터 오름차순으로 정렬합니다
 * 2. 간선을 앞에서부터 하나씩 꺼내서 현재의 트리에 추가합니다
 * 3. 이때 만약 트리가 순환하게 된다면 추가하지 않습니다
 * 4. 간선이 (노드(정점)의 개수 - 1) 만큼 사용 되면 현재의 비용이 최소 신장 트리의 가중치의 합이 됩니다
 *
 * 크루스칼 알고리즘은 간선을 중심으로 최소 신장 트리를 해결하는 알고리즘입니다
 * 간선의 가중치만을 고려하여 그리디하게 해결하는 알고리즘이기 때문에
 * 간선을 추가할 때마다 트리의 순환이 이루어지는지 확인해야 합니다
 * 일반적으로 유니온 파인드 알고리즘을 사용하여 트리의 순환을 확인하고 추가합니다
 * 크루스칼 알고리즘은 간선을 가중치를 기준으로 정렬해야 하기 때문에
 * 간선이 많은 경우에는 프림 알고리즘을 사용해야 합니다
 */

class MST_Kruskal {
    fun main() {
        val (v, e) = readln().split(" ").map(String::toInt)
        val pq = PriorityQueue<IntArray> { arr1, arr2 -> arr1[2] - arr2[2] } // 간선의 가중치를 기준으로 오름차순 정렬합니다

        repeat(e) {
            val (a, b, c) = readln().split(" ").map(String::toInt)
            pq.add(intArrayOf(a - 1, b - 1, c))
        }

        val uf = UnionFind(v)

        while (pq.isNotEmpty()) {
            val c = pq.poll()!! // 가중치를 기준으로 정렬된 간선을 하나씩 꺼냅니다
            uf.union(c[0], c[1], c[2]) // 유니온 파인드 알고리즘으로 통해 순환을 확인하고 트리에 추가합니다
            if (uf.cnt == v - 1) break // (노드(정점) - 1)개의 간선을 사용한 경우 break 합니다
        }

        println(uf.result) // 최소 신장 트리의 가중치의 합을 출력합니다
    }
}

// 유니온 파인드 알고리즘입니다
class UnionFind(n: Int) {
    private val parent = IntArray(n) { it } // 부모 배열은 생성시 자기 자신을 가르키도록 선언합니다
    private val rank = IntArray(n)
    var result = 0 // 가중치의 합입니다
    var cnt = 0 // 간선 사용 개수입니다

    // 최상위 루트 노드를 찾는 메소드입니다
    private fun find(node: Int): Int {
        if (parent[node] != node) {
            return find(parent[node])
        }
        return parent[node]
    }

    // 두 집합을 합치는 메소드입니다
    fun union(node1: Int, node2: Int, num: Int) {
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

        result += num // 가중치를 더합니다
        cnt++ // 간선 사용 개수를 증가합니다
    }
}
