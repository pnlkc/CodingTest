import java.util.LinkedList

data class Pos(val x: Int, val y: Int, val arr: IntArray)

fun main() {
    val sb = StringBuilder()
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)
    val dirMap = mutableMapOf<Int, IntArray>(
        0 to intArrayOf(1, 5, 0, 3, 4, 2),
        1 to intArrayOf(2, 0, 5, 3, 4, 1),
        2 to intArrayOf(3, 1, 2, 5, 0, 4),
        3 to intArrayOf(4, 1, 2, 0, 5, 3),
    )

    p@ for (tc in 1..3) {
        val map = Array(6) { IntArray(6) }
        val q = LinkedList<Pos>()
        val isVisit = Array(6) { BooleanArray(6) }
        val check = BooleanArray(6)

        for (i in 0 until 6) {
            val input = readln().split(" ").map { it.toInt() }

            for (j in 0 until 6) {
                map[i][j] = input[j]

                if (map[i][j] == 1 && q.isEmpty()) {
                    q.add(Pos(j, i, IntArray(6) { it }))
                    isVisit[i][j] = true
                    check[0] = true
                }
            }
        }

        while (q.isNotEmpty()) {
            val (cx, cy, cArr) = q.poll()!!
            
            for (d in 0..3) {
                val nx = cx + dx[d]
                val ny = cy + dy[d]

                if (nx < 0 || ny < 0 || nx >= 6 || ny >= 6) continue
                if (map[ny][nx] == 0 || isVisit[ny][nx]) continue

                val temp = IntArray(6)

                for (i in 0..5) {
                    temp[i] = cArr[dirMap[d]!![i]]
                }

                if (check[temp[0]]) {
                    sb.appendLine("no")
                    continue@p
                }

                q.add(Pos(nx, ny, temp))
                isVisit[ny][nx] = true
                check[temp[0]] = true
            }
        }

        sb.appendLine("yes")
    }

    print(sb)
}