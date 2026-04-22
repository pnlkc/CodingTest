import java.util.*

fun main() {
    repeat(readln().toInt()) {
        val (m, n, k) = readln().split(" ").map { it.toInt() }
        val graph = Array(m) { BooleanArray(n) }
        var count = 0

        repeat(k) {
            readln().split(" ").map { it.toInt() }.run { graph[this[0]][this[1]] = true }
        }

        val xL = intArrayOf(1, -1, 0, 0)
        val yL = intArrayOf(0, 0, 1, -1)

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (graph[i][j]) {
                    count++
                    val queue = LinkedList<IntArray>()
                    queue.add(intArrayOf(i, j))

                    while (queue.isNotEmpty()) {
                        val c = queue.poll()!!

                        for (l in 0..3) {
                            if (c[0] + xL[l] !in 0 until m) continue
                            if (c[1] + yL[l] !in 0 until n) continue
                            if (graph[c[0] + xL[l]][c[1] + yL[l]]) {
                                graph[c[0] + xL[l]][c[1] + yL[l]] = false
                                queue.add(intArrayOf(c[0] + xL[l], c[1] + yL[l]))
                            }
                        }
                    }
                }
            }
        }

        println(count)
    }
}