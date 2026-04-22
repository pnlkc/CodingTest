fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visit = BooleanArray(n + 1) { false }
    
    repeat(m) {
        readln().split(" ").run { 
            graph[this[0].toInt()].add(this[1].toInt())
            graph[this[1].toInt()].add(this[0].toInt())
        }
    }
    
    dfs(graph, visit, 1)
    
    println(visit.count { it } - 1)
}

fun dfs(graph: Array<MutableList<Int>>, visit: BooleanArray, c: Int) {
    visit[c] = true
    
    for (i in graph[c]) {
        if (!visit[i]) dfs(graph, visit, i)
    }
}