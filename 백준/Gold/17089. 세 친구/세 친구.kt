fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Int>() }
    var result = -1

    for (i in 1..M) {
        val (A, B) = readln().split(" ").map { it.toInt() }

        graph[A].add(B)
        graph[B].add(A)
    }

    for (i in 1..N - 2) {
        if (graph[i].size < 2) continue

        for (j in graph[i]) {
            if (graph[j].size < 2) continue

            for (k in graph[j]) {
                if (graph[k].size < 2) continue
                if (!graph[i].contains(k)) continue
                if (!graph[k].contains(i)) continue

                result = if (result == -1) {
                    graph[i].size + graph[j].size + graph[k].size - 6
                } else {
                    minOf(result, graph[i].size + graph[j].size + graph[k].size - 6)
                }
            }
        }
    }

    println(result)
}