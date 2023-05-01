import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine().toInt()) {
        val (v, e) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(v + 1) { mutableListOf<Int>() }

        for(i in 1..e) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        val isVisit = BooleanArray(v + 1)
        var r = true

        p@for (i in 1..v) {
            if (isVisit[i]) continue
            if (graph[i].size == 0) {
                isVisit[i] = true
                continue
            }

            val nodeColor = IntArray(v + 1) { -1 }
            val queue = LinkedList<Pair<Int, Int>>()

            queue.add(i to 0)
            isVisit[i] = true
            nodeColor[i] = 0

            while (queue.isNotEmpty()) {
                val (node, color) = queue.poll()!!

                for (j in graph[node]) {
                    if (!isVisit[j]) {
                        queue.add(j to color.inv())
                        isVisit[j] = true
                        nodeColor[j] = color.inv()
                    } else if (nodeColor[j] == color) {
                        r = false
                        break@p
                    }
                }
            }
        }

        println(if (r) "YES" else "NO")
    }
}