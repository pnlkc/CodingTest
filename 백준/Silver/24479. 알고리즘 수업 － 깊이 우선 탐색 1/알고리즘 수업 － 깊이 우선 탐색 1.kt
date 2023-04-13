var visitCount = 1

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Int>() }
    val visit = IntArray(n)

    repeat(m) {
        readln().split(" ").map { it.toInt() - 1 }.run {
            graph[this[0]].add(this[1])
            graph[this[1]].add(this[0])
        }
    }

    graph.forEach { it.sort() }

    dfs(graph, visit, r - 1)

    println(visit.joinToString("\n"))
}

fun dfs(graph: Array<MutableList<Int>>, visit: IntArray, r: Int) {
    visit[r] = visitCount++

    for (i in graph[r]) {
        if (visit[i] == 0) dfs(graph, visit, i)
    }
}