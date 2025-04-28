var result = -1
var isVisit = booleanArrayOf()
var graph: Array<IntArray> = arrayOf()

fun main() {
    val N = readln().toInt()
    val M = readln().toInt()

    graph = Array(N + 1) { IntArray(N + 1) }
    isVisit = BooleanArray(N + 1)

    for (i in 0 until M) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }

        graph[u][v] = maxOf(graph[u][v], d)
    }

    isVisit[0] = true
    calc(0, 0)

    println(result)
}

fun calc(node: Int, sum: Int) {
    if (!isVisit.contains(false)) {
        if (graph[node][0] != 0) result = maxOf(result, sum + graph[node][0])
        return
    }

    for (i in graph[node].indices) {
        if (graph[node][i] == 0) continue
        if (isVisit[i]) continue

        isVisit[i] = true
        calc(i, sum + graph[node][i])
        isVisit[i] = false
    }
}
