var graph = arrayOf(mutableListOf<Int>())
var isVisit = booleanArrayOf()
var result = 0L
var cnt = 1

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }

    graph = Array(n) { mutableListOf() }
    isVisit = BooleanArray(n)

    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() - 1 }

        graph[u].add(v)
        graph[v].add(u)
    }

    graph.forEach { it.sort() }

    dfs(r - 1, 0)

    println(result)
}

fun dfs(node: Int, d: Int) {
    isVisit[node] = true

    result += d.toLong() * cnt++

    for (next in graph[node]) {
        if (isVisit[next]) continue

        dfs(next, d + 1)
    }
}