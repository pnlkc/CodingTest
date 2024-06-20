import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    var cnt = 0
    var max = 0
    val q = LinkedList<Pair<Int, Int>>()
    val isVisit = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) continue
            if (isVisit[i][j]) continue

            var size = 1
            cnt++
            q.offer(j to i)
            isVisit[i][j] = true

            while (q.isNotEmpty()) {
                val (cx, cy) = q.poll()!!

                for (d in 0 until 4) {
                    val nx = cx + dx[d]
                    val ny = cy + dy[d]

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue
                    if (map[ny][nx] == 0) continue
                    if (isVisit[ny][nx]) continue

                    q.offer(nx to ny)
                    isVisit[ny][nx] = true
                    size++
                }
            }

            max = maxOf(max, size)
        }
    }
    
    println(cnt)
    println(max)
}