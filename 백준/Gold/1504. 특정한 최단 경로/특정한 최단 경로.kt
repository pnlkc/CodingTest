import java.util.PriorityQueue

fun main() {
    val (n, e) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    
    repeat(e) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val (v1, v2) = readln().split(' ').map(String::toInt)
    val dist1 = dijkstra(1, n, graph)
    val distV1 = dijkstra(v1, n, graph)
    val distV2 = dijkstra(v2, n, graph)
    val v1v2 = intArrayOf(dist1[v1], distV1[v2], distV2[n])
    val v2v1 = intArrayOf(dist1[v2], distV2[v1], distV1[n])

    println(
        intArrayOf(if (v1v2.contains(-1)) -1 else v1v2.sum(), if (v2v1.contains(-1)) -1 else v2v1.sum() )
            .filter { it > 0 }
            .minOrNull() ?: -1
    )
}

fun dijkstra(i: Int, n: Int, graph: Array<MutableList<Pair<Int,Int>>>): IntArray {
    val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val dist = IntArray(n + 1) { -1 }

    pQueue.add(i to 0)
    dist[i] = 0

    while (pQueue.isNotEmpty()) {
        val (cNode, cDist) = pQueue.poll()!!

        if (dist[cNode] != -1 && cDist > dist[cNode]) continue

        for ((jNode, jDist) in graph[cNode]) {
            if (dist[jNode] == -1 || dist[jNode] > cDist + jDist) {
                dist[jNode] = dist[cNode] + jDist
                pQueue.add(jNode to dist[jNode])
            }
        }
    }
    
    return dist
}