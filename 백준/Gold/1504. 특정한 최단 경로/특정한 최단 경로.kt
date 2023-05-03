import java.util.PriorityQueue

fun main() {
    val (n, e) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = Array(3) { IntArray(n + 1) { -1 } }

    repeat(e) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val (v1, v2) = readln().split(' ').map(String::toInt)
    val arr = intArrayOf(1, v1, v2)

    for (i in dist.indices) {
        pQueue.add(arr[i] to 0)
        dist[i][arr[i]] = 0

        while (pQueue.isNotEmpty()) {
            val (cNode, cDist) = pQueue.poll()!!

            if (dist[i][cNode] != -1 && cDist > dist[i][cNode]) continue

            for ((jNode, jDist) in graph[cNode]) {
                if (dist[i][jNode] == -1 || dist[i][jNode] > cDist + jDist) {
                    dist[i][jNode] = dist[i][cNode] + jDist
                    pQueue.add(jNode to dist[i][jNode])
                }
            }
        }
    }
    
    val v1v2 = intArrayOf(dist[0][v1], dist[1][v2], dist[2][n])
    val v2v1 = intArrayOf(dist[0][v2], dist[2][v1], dist[1][n])
    
    println(
        intArrayOf(if (v1v2.contains(-1)) -1 else v1v2.sum(), if (v2v1.contains(-1)) -1 else v2v1.sum() )
            .filter { it > 0 }
            .minOrNull() ?: -1
    )
}