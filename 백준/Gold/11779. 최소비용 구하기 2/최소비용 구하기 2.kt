import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array(n) { mutableMapOf<Int, Int>() }
    val dist = Array(n) { Int.MAX_VALUE to "" }
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    repeat(m) {
        val (a, b, c) = readln().split(' ').map(String::toInt)

        if (graph[a - 1][b - 1] == null) graph[a - 1][b - 1] = c
        else graph[a - 1][b - 1] = minOf(graph[a - 1][b - 1]!!, c)
    }

    val (s, e) = readln().split(' ').map { it.toInt() - 1 }

    queue.add(s to 0)
    dist[s] = 0 to "${s + 1}"

    while (queue.isNotEmpty()) {
        val (cNode, cDist) = queue.poll()!!

        if (dist[cNode].first < cDist) continue

        for ((iNode, iDist) in graph[cNode]) {
            if (dist[iNode].first > dist[cNode].first + iDist) {
                dist[iNode] = dist[cNode].first + iDist to dist[cNode].second + " ${iNode + 1}"
                queue.add(iNode to dist[iNode].first)
            }
        }
    }

    println(dist[e].first)
    println(dist[e].second.split(' ').count())
    println(dist[e].second)
}