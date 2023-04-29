import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = Array(n) { readln().toCharArray() }
    val visit = Array(n) { Array(m) { IntArray(2) { -1 } } }
    val queue = LinkedList<Triple<Int, Int, Int>>()

    queue.add(Triple(0, 0, 0))
    visit[0][0][0] = 1

    while (queue.isNotEmpty()) {
        val (y, x, canDestroy) = queue.poll()!!
        val xR = intArrayOf(1, -1, 0, 0)
        val yR = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val nx = x + xR[i]
            val ny = y + yR[i]

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
            if (canDestroy == 1 && graph[ny][nx] == '1') continue

            if (graph[ny][nx] == '1') {
                if (visit[ny][nx][1] == -1 || visit[ny][nx][1] > visit[y][x][0] + 1) {
                    queue.add(Triple(ny, nx, 1))
                    visit[ny][nx][1] = visit[y][x][0] + 1
                }
            } else {
                if (visit[ny][nx][canDestroy] == -1 || visit[ny][nx][canDestroy] > visit[y][x][canDestroy] + 1) {
                    queue.add(Triple(ny, nx, canDestroy))
                    visit[ny][nx][canDestroy] = visit[y][x][canDestroy] + 1
                }
            }
        }
    }

    println(visit[n - 1][m - 1].filter { it != -1 }.minOrNull() ?: -1)
}