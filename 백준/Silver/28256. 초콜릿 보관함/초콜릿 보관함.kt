import java.util.LinkedList
import java.util.StringTokenizer

data class Pos(val x: Int, val y: Int)

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (tc in 1..T) {
        val arr = Array(3) { CharArray(3) }

        for (i in 0 until 3) {
            val input = readln()

            for (j in 0 until 3) {
                arr[i][j] = input[j]
            }
        }

        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val nArr = IntArray(n)
        val result = mutableListOf<Int>()

        for (i in 0 until n) {
            nArr[i] = st.nextToken().toInt()
        }

        val isVisit = Array(3) { BooleanArray(3) }
        val q = LinkedList<Pos>()

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (arr[i][j] != 'O' || isVisit[i][j]) continue

                var cnt = 1
                q.add(Pos(j, i))
                isVisit[i][j] = true

                while (q.isNotEmpty()) {
                    val c = q.poll()!!

                    for (d in 0 until 4) {
                        val nx = c.x + dx[d]
                        val ny = c.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue
                        if (arr[ny][nx] != 'O' || isVisit[ny][nx]) continue

                        q.add(Pos(nx, ny))
                        isVisit[ny][nx] = true
                        cnt++
                    }
                }

                result.add(cnt)
            }
        }

        var isTrue = true
        result.sort()

        if (result.size != n) {
            isTrue = false
        } else {
            for (i in 0 until n) {
                if (nArr[i] != result[i]) {
                    isTrue = false
                    break
                }
            }

        }

        sb.appendLine(if (isTrue) 1 else 0)
    }

    print(sb)
}