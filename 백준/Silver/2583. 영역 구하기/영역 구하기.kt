import java.util.LinkedList

fun main() {
    val (M, N, K) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { BooleanArray(N) }
    var result = 0
    val list = mutableListOf<Int>()
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 1..K) {
       val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

        for (j in x1 until x2) {
            for (k in y1 until y2) {
                map[k][j] = true
            }
        }
    }

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (map[i][j]) continue

            var cnt = 1
            val q = LinkedList<Pair<Int, Int>>()
            q.offer(i to j)
            map[i][j] = true

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                for (d in 0..3) {
                    val nx = c.second + dx[d]
                    val ny = c.first + dy[d]

                    if (nx !in 0 until N || ny !in 0 until M) continue
                    if (map[ny][nx]) continue

                    q.offer(ny to nx)
                    map[ny][nx] = true
                    cnt++
                }
            }

            result++
            list.add(cnt)
        }
    }

    println(result)
    list.sort()
    println(list.joinToString(" "))
}