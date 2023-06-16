fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n) { mutableSetOf<Int>() }
    val dist = Array(n) { IntArray(n) }

    repeat(m) {
        val (a, b) = readln().split(' ').map { it.toInt() - 1 }

        graph[a].add(b)
        graph[b].add(a)
        dist[a][b] = 1
        dist[b][a] = 1
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || i == k || j == k) continue
                if (dist[i][k] == 0 || dist[k][j] == 0) continue

                if (dist[i][j] == 0 || dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    var minToIndex = Int.MAX_VALUE to -1
    
    dist.forEachIndexed { i, ints ->
        ints.sum().run {
            if (this < minToIndex.first) minToIndex = this to i + 1
        }
    }
    
    println(minToIndex.second)
}