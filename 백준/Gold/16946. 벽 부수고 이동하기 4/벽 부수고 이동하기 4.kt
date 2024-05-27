import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    val result = Array(N) { IntArray(M) }
    val group = Array(N) { IntArray(M) }
    val groupMap = mutableMapOf<Int, Int>()
    var groupNum = 1
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j].digitToInt()
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 0 && group[i][j] == 0) {
                var cnt = 1
                val q = LinkedList<Pos>()

                q.offer(Pos(j, i))
                group[i][j] = groupNum

                while (q.isNotEmpty()) {
                    val c = q.poll()!!

                    for (d in 0 until 4) {
                        val nx = c.x + dx[d]
                        val ny = c.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
                        if (group[ny][nx] != 0) continue
                        if (map[ny][nx] == 1) continue

                        q.offer(Pos(nx, ny))
                        group[ny][nx] = groupNum
                        cnt++
                    }
                }

                groupMap[groupNum++] = cnt
            }
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 1) {
                val groupList = mutableSetOf<Int>()

                for (d in 0 until 4) {
                    val nx = j + dx[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue

                    if (group[ny][nx] != 0) groupList.add(group[ny][nx])
                }

                result[i][j] = (1 + groupList.sumOf { groupMap[it]!! }) % 10
            }
        }
    }

    for (i in 0 until N) {
        println(result[i].joinToString(""))
    }
}