import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val tree = Array<MutableList<Pair<Int, Int>>>(n) { mutableListOf() }
    repeat(n) {
        val st = StringTokenizer(readln())
        val node = st.nextToken().toInt() - 1
        while (st.hasMoreTokens()) {
            val t1 = st.nextToken().toInt() - 1
            if (t1 == -2) break
            tree[node].add(t1 to st.nextToken().toInt())
        }
    }

    val visit = IntArray(n) { -1 }
    visit[0] = 0
    dfs(0, 0, tree, visit)
    val visit2 = IntArray(n) { -1 }
    dfs(visit.indexOf(visit.maxOf { it }), 0, tree, visit2)

    println(visit2.maxOrNull()!!)
}

fun dfs(node: Int, dist: Int, graph: Array<MutableList<Pair<Int, Int>>>, visit: IntArray) {
    visit[node] = maxOf(visit[node], dist)

    for ((cN, cD) in graph[node]) {
        if (visit[cN] == -1) dfs(cN, dist + cD, graph, visit)
    }
}