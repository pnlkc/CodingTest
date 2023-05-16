// 다익스트라는 시작 노드에서 다른 모든 노드까지의 최단거리를 구하는 알고리즘입니다.
// 다익스트라 알고리즘은 간선이 음수일 때는 사용할 수 없습니다. (벨만-포드 알고리즘 사용이 필요합니다)
// 시간복잡도는 V(정점의 수), E(간선의 수)일 때, O((E + V)logV) 입니다.
// ex) 백준 1753번 최단경로
class 다익스트라 {
    fun dijkstra() {
        val sb = StringBuilder()
        val (v, e) = readln().split(' ').map(String::toInt)
        val k = readln().toInt()
        val graph = Array(v + 1) { mutableMapOf<Int, Int>() }
        val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        val dist = IntArray(v + 1) { -1 }

        pQueue.add(k to 0)
        dist[k] = 0

        // 그래프 생성
        repeat(e) {
            val (a, b, c) = readln().split(' ').map(String::toInt)
            graph[a][b] = if (graph[a][b] == null) c else minOf(graph[a][b]!!, c)
        }

        // 다익스트라 알고리즘
        while (pQueue.isNotEmpty()) {
            val (cn, cd) = pQueue.poll()!!

            // 경유해서 가는 더 짧은 경로가 존재하면 continue
            if (dist[cn] != -1 && cd > dist[cn]) continue

            for ((n, d) in graph[cn]) {
                // 인접한 노드의 최단거리보다 현재 노드를 경유해서 가는 것이 더 짧은 경로면 pQueue에 추가
                if (dist[n] == -1 || dist[n] > dist[cn] + d) {
                    dist[n] = dist[cn] + d
                    pQueue.add(n to dist[n])
                }
            }
        }

        for (i in 1..v) {
            sb.appendLine(if (dist[i] == -1) "INF" else dist[i])
        }

        println(sb)
    }
}
