fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val graph = Array(n) { intArrayOf() }

    repeat(n) {
        graph[it] = readln().split(' ').map(String::toInt).toIntArray()
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][j] == 1 || graph[i][k] == 0 || graph[k][j] == 0) continue
                graph[i][j] = 1
            }
        }
    }

    graph.forEach { sb.appendLine(it.joinToString(" ")) }

    println(sb)
}