import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val graph = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until n) {
            graph[i][j] = input[j] == 0
        }
    }

    val q = LinkedList<Int>()
    val isVisit = BooleanArray(n)
    val result = mutableListOf<MutableList<Int>>()

    for (i in 0 until n) {
        if (isVisit[i]) continue

        result.add(mutableListOf(i))
        q.add(i)
        isVisit[i] = true

        while (q.isNotEmpty()) {
            val c = q.poll()!!

            for (nn in 0 until n) {
                if (graph[c][nn] && graph[nn][c] && !isVisit[nn]) {
                    result.last().add(nn)
                    q.add(nn)
                    isVisit[nn] = true
                }
            }
        }
    }

    result.forEach { it.sort() }
    result.sortBy { it.first() }

    for (i in result.indices) {
        if (result[i].size == 1) {
            println(0)
            return
        }
    }

    println(result.size)

    for (i in result.indices) {
        println(result[i].map { it + 1 }.joinToString(" "))
    }
}