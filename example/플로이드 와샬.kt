// 플로이드 와샬 알고리즘은 그래프 탐색 알고리즘입니다.
// 모든 노드에서 모든 노드로 가는 최단거리를 구하는 알고리즘입니다.
// 시간 복잡도는 V(정점의 수)일 때 O(V^3)로 정점의 수가 작은 경우에만 사용할 수 있습니다.
// ex) 백준 11404번 플로이드
class 플로이드_와샬 {
    fun floyd_Warshall() {
        val bw = BufferedReader(InputStreamReader(System.`in`))
        val n = bw.readLine().toInt()
        val m = bw.readLine().toInt()
        val dist = Array(n) { LongArray(n) }

        repeat(m) {
            val (a, b, c) = bw.readLine().split(' ').map(String::toInt)

            if (dist[a - 1][b - 1] == 0L) dist[a - 1][b - 1] = c.toLong()
            else dist[a - 1][b - 1] = minOf(dist[a - 1][b - 1], c.toLong())
        }

        // 거쳐가는 노드(k)부터 for문 실행
        for (k in 0 until n) {
            // 시작 노드(i) for문 실행
            for (i in 0 until n) {
                // 도착 노드(j) for문 실행
                for (j in 0 until n) {
                    // 같은 번호가 있으면 continue
                    if (i == j || k == i || k == j) continue

                    if (dist[i][k] == 0L || dist[k][j] == 0L) continue

                    if (dist[i][j] == 0L || dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                    }
                }
            }
        }

        dist.forEach { println(it.joinToString(" ")) }
    }
}
