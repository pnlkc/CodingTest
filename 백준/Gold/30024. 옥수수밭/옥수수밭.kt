import java.util.PriorityQueue

data class Data(val x: Int, val y: Int, val v: Int)

fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val pq = PriorityQueue<Data> { d1, d2 -> d2.v - d1.v }
    val isVisit = Array(N) { BooleanArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]

            if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                pq.add(Data(j, i, map[i][j]))
                isVisit[i][j] = true
            }
        }
    }

    val K = readln().toInt()

    for (i in 1..K) {
        val cd = pq.poll()!!

        sb.appendLine("${cd.y + 1} ${cd.x + 1}")

        for (d in 0..3) {
            val nx = cd.x + dx[d]
            val ny = cd.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
            if (isVisit[ny][nx]) continue

            pq.add(Data(nx, ny, map[ny][nx]))
            isVisit[ny][nx] = true
        }
    }

    print(sb)
}