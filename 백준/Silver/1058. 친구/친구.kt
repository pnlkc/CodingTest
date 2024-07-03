fun main() {
    val N = readln().toInt()
    val graph = Array(N) { CharArray(N) }
    val dist = Array(N) { IntArray(N) }
    var result = 0

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until N) {
            graph[i][j] = input[j]
            if (graph[i][j] == 'Y') dist[i][j] = 1
        }
    }

    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (i == k || j == k || i == j) continue
                if (graph[i][k] == 'N' || graph[k][j] == 'N') continue

                if (dist[i][j] == 0 || dist[i][j] == 1) {
                    dist[i][j] = 2
                }
            }
        }
    }

    for (i in 0 until N) {
        var cnt = 0

        for (j in 0 until N) {
            if (dist[i][j] in 1..2) cnt++
        }

        result = maxOf(result, cnt)
    }

    println(result)
}