fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (u, v) = readln().split(' ').map(String::toInt)
        graph[u].add(v)
        graph[v].add(u)
    }

    var count = 0
    val isVisit = BooleanArray(n + 1)

    for (i in 1..n) {
        if (isVisit[i]) continue
        else count++
        dfs(i, graph, isVisit)
    }

    println(count)
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, isVisit: BooleanArray) {
    isVisit[node] = true
    graph[node].forEach { if (!isVisit[it]) dfs(it, graph, isVisit) }
}