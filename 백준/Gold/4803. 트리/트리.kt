var hasCycle = false

fun main() {
    val sb = StringBuilder()
    var tcNum = 1
    while (true) {
        val (n, m) = readln().split(' ').map(String::toInt)
        if (n == 0 && m == 0) break

        val graph = Array(n + 1) { mutableListOf<Int>() }

        repeat(m) {
            val (a, b) = readln().split(' ').map(String::toInt)
            graph[a].add(b)
            graph[b].add(a)
        }

        var count = 0
        val visit = BooleanArray(n + 1)
        for (i in 1..n) {
            if (visit[i]) continue

            hasCycle = false
            dfs(graph, visit, i, 0)

            if (!hasCycle) {
                count++
                visit[i] = true
            }
        }

        when (count) {
            0 -> sb.appendLine("Case $tcNum: No trees.")
            1 -> sb.appendLine("Case $tcNum: There is one tree.")
            else -> sb.appendLine("Case $tcNum: A forest of $count trees.")
        }

        tcNum++
    }

    println(sb)
}

fun dfs(graph: Array<MutableList<Int>>, visit: BooleanArray, node: Int, parent: Int) {
    visit[node] = true

    for (i in graph[node]) {
        if (visit[i] && i != parent) hasCycle = true
        if (!visit[i]) dfs(graph, visit, i, node)
    }
}