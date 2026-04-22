import java.util.*

fun main() {
    p@for (tcNum in 1..readln().toInt()) {
        val n = readln().toInt()
        val (x1, y1) = readln().split(" ").map { it.toInt() }
        val (x2, y2) = readln().split(" ").map { it.toInt() }
        
        if (x1 == x2 && y1 == y2) {
            println(0)
            continue@p
        }

        val visit = Array(n) { IntArray(n) }
        val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
        val dy = intArrayOf(1, -1, 2, -2, 2, -2, 1, -1)
        val queue = LinkedList<IntArray>()
        
        queue.add(intArrayOf(x1, y1))

        while(queue.isNotEmpty()) {
            val c = queue.poll()!!
            val visitC = visit[c[0]][c[1]] + 1

            for (i in 0 until 8) {
                val nx = c[0] + dx[i]
                val ny = c[1] + dy[i]

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue

                if (visit[nx][ny] == 0 || visit[nx][ny] > visitC) {
                    visit[nx][ny] = visitC
                    queue.add(intArrayOf(nx, ny))
                }

                if (nx == x2 && ny == y2) {
                    println(visitC)
                    continue@p
                }
            }
        }
    }
}