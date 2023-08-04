// 벨만-포드 알고리즘은 그래프 탐색 알고리즘입니다.
// 시작 노드에서 다른 노드까지 이동하는 최솟값을 구하는 알고리즘입니다.
// 다익스트라 알고리즘과는 달리 벨만-포드 알고리즘은 음의 가중치를 갖는 간선이 있어도 사용 가능 합니다.
// 시간복잡도는 V(정점의 수), E(간선의 수)일 때, O(V(정점의 수) * E(간선의 수))로 다익스트라 알고리즘보다 느립니다.
// ex) 백준 11657번 타임머신
class 벨만_포드 {
    fun question() {
        val (n, m) = readln().split(' ').map(String::toInt)
        val graph = Array(n + 1) { mutableMapOf<Int, Int>() }

        repeat(m) {
            val (a, b, c) = readln().split(' ').map(String::toInt)
            if (graph[a][b] == null) graph[a][b] = c else graph[a][b] = minOf(c, graph[a][b]!!)
        }

        val (result, arr) = bellmanFord(n, graph)

        if (result) arr.forEachIndexed { idx, i -> if (idx > 1) println(if (i != Long.MAX_VALUE) i else -1) }
        else println(-1)
    }

    fun bellmanFord(n: Int, graph: Array<MutableMap<Int, Int>>): Pair<Boolean, LongArray> {
        val dist = LongArray(n + 1) { Long.MAX_VALUE }
        dist[1] = 0

        // 노드의 갯수(n) - 1 만큼까지 경유할 수 있으므로 n - 1회 반복합니다.
        repeat(n - 1) {
            var isChange = false // 
            // 1번부터 n번까지 모든 노드을 탐색해야 하므로 1..n을 범위로 합니다.
            for (i in 1..n) {
                // 현재 노드를 경유했을 때 더 작아지는 경우가 있는지 현재 노드의 인접 노드들을 확인합니다.
                for ((cn, cd) in graph[i]) {
                    if (dist[i] != Long.MAX_VALUE && dist[i] + cd < dist[cn]) {
                        dist[cn] = dist[i] + cd
                        isChange = true
                    }
                }
            }

            if (!isChange) return true to dist;
        }

        //노드의 갯수(n) - 1 개를 경유한 후에도 계속 작아질 수 있다면 음수 사이클이 발생하는 경우입니다.
        for (i in 1..n) {
            for ((cn, cd) in graph[i]) {
                if (dist[cn] != Long.MAX_VALUE && dist[i] + cd < dist[cn]) {
                    return false to longArrayOf()
                }
            }
        }

        return true to dist
    }
}
