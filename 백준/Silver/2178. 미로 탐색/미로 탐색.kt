import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().toCharArray() }
    val visit = Array(n) { IntArray(m) }
    val xL = intArrayOf(1, -1, 0, 0)
    val yL = intArrayOf(0, 0, 1, -1)

    val queue = LinkedList<IntArray>()
    queue.add(intArrayOf(0, 0))
    visit[0][0] = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()!!

        for (l in 0..3) {
            if (x + xL[l] !in 0 until n) continue
            if (y + yL[l] !in 0 until m) continue
            if (graph[x + xL[l]][y + yL[l]] == '0') continue

            graph[x + xL[l]][y + yL[l]] = '0'
            visit[x + xL[l]][y + yL[l]] = visit[x][y] + 1
            queue.add(intArrayOf(x + xL[l], y + yL[l]))
            
            if (x + xL[l] == n - 1 && y + yL[l] == m - 1) {
                println(visit[n - 1][m - 1])
                return
            }
        }
    }
}