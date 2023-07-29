import java.util.PriorityQueue

/**
 * 최소 신장 트리(Minimum Spanning Tree, MST)는
 * 모든 노드가 서로 연결된 순환하지 않는 트리 중
 * 가중치의 합이 최소가 되는 트리를 의미합니다
 *
 * 프림(Prim) 알고리즘은 최소 신장 트리 문제를 풀 때 사용하는 알고리즘 중 하나입니다
 * 프림 알고리즘은 시작 노드를 선택하고 그리디하게 확장하여 탐색하는 알고리즘입니다
 *
 * 진행과정은 아래와 같습니다
 * 1. 임의의 시작 노드(정점)를 선택합니다
 * 2. 노드 방문 여부 리스트에 시작 노드를 방문 처리합니다
 * 3. 현재 트리에 포함된 노드들과 포함되지 않은 노드 중 가중치가 가장 낮은 간선을 선택하여 현재 트리에 추가합니다
 * 4. 선택한 포함되지 않은 노드를 방문했다고 처리합니다
 * 5. 위의 과정을 반복하여 모든 노드를 방문합니다
 * 6. 모든 노드를 방문한 경우 현재의 비용이 최소 신장 트리의 가중치의 합이 됩니다
 *
 * 프림 알고리즘과 크루스칼 알고리즘의 차이는 다음과 같습니다
 * 1. 프림 알고리즘은 시작 노드를 선택할 수 있습니다
 * 2. 프림 알고리즘은 간선을 추가할 때 노드의 방문 여부만 확인하고 순환 사이클은 확인하지 않습니다
 * 3. 2번의 이유로 프림 알고리즘은 유니온 파인드 알고리즘을 사용하지 않아도 됩니다
 *
 * 때문에 시작 정점을 설정해야 하거나 간선이 많은 밀집 그래프의 경우 프림 알고리즘을
 * 시작 정점을 정하지 않아도 되거나 희소 그래프의 경우 크루스칼 알고리즘을 사용하면 됩니다
 *
 * ex) 백준 1197번 최소 스패닝 트리
 */

class MST_Prim {
    fun prim() {
        val (v, e) = readln().split(" ").map(String::toInt)
        val tree = Array(v) { mutableListOf<Pair<Int, Int>>() }

        repeat(e) {
            val (a, b, c) = readln().split(" ").map(String::toInt)
            tree[a - 1].add(b - 1 to c)
            tree[b - 1].add(a - 1 to c)
        }

        val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 -> p1.second - p2.second } // 간선의 가중치를 기준으로 오름차순 정렬합니다
        val isVisit = BooleanArray(v) // 노드의 방문 여부를 표시하는 배열입니다
        var result = 0 // 가중치의 합을 담는 변수입니다
        isVisit[0] = true // 시작 노드를 방문 표시합니다
        pq.addAll(tree[0]) // 시작 노드의 간선을 모두 추가합니다

        while (pq.isNotEmpty()) {
            val (cn, cd) = pq.poll()!!

            // 해당 노드를 방문했는 검사합니다
            if (!isVisit[cn]) {
                result += cd // 해당 간선의 가중치를 더합니다
                isVisit[cn] = true // 해당 노드를 방문 표시합니다
                pq.addAll(tree[cn]) // 해당 노드의 간선들을 모두 추가합니다

                if (!isVisit.contains(false)) break // 모든 노드를 방문했으면 종료합니다
            }
        }

        println(result) // 최소 신장 트리의 가중치의 합을 출력합니다
    }
}
