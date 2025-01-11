import java.util.LinkedList
import kotlin.math.pow

data class Pos(val x: Int, val y: Int)

var temp = arrayOf(intArrayOf())

fun powToInt(n: Int) = 2.0.pow(n).toInt()

fun main() {
    val (N, Q) = readln().split(" ").map { it.toInt() }
    val powN = powToInt(N)
    val map = Array(powN) { IntArray(powN) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    var sum = 0
    var max = 0

    for (i in 0 until powN) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until powN) {
            map[i][j] = input[j]
        }
    }

    val cL = readln().split(" ").map { it.toInt() }

    for (c in cL) {
        val powC = powToInt(c)

        // 1. 구간 나누기
        temp = Array(powC) { IntArray(powC) }

        for (i in 0 until powN step powC) {
            for (j in 0 until powN step powC) {
                rotate(j, i, j + powC - 1, i + powC - 1, powC, map)
            }
        }

        // 2. 인접한 칸 확인하기
        temp = Array(powN) { IntArray(powN) }

        for (i in 0 until powN) {
            for (j in 0 until powN) {
                var cnt = 0

                for (d in 0..3) {
                    val nx = j + dx[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= powN || ny >= powN) continue

                    if (map[ny][nx] > 0) cnt++
                }

                temp[i][j] = map[i][j]
                if (cnt < 3) temp[i][j] = maxOf(0, temp[i][j] - 1)
            }
        }

        for (i in 0 until powN) {
            for (j in 0 until powN) {
                map[i][j] = temp[i][j]
            }
        }
    }

    // 3. 얼음 합 구하기
    for (i in 0 until powN) {
        for (j in 0 until powN) {
            sum += map[i][j]
        }
    }

    // 4. 얼음 덩어리 크기 확인하기
    val q = LinkedList<Pos>()
    val isVisit = Array(powN) { BooleanArray(powN) }

    for (i in 0 until powN) {
        for (j in 0 until powN) {
            if (isVisit[i][j] || map[i][j] <= 0) continue

            var cnt = 0
            q.add(Pos(j, i))
            isVisit[i][j] = true

            while (q.isNotEmpty()) {
                val c = q.poll()!!
                cnt++

                for (d in 0..3) {
                    val nx = c.x + dx[d]
                    val ny = c.y + dy[d]

                    if (nx < 0 || ny < 0 || nx >= powN || ny >= powN) continue
                    if (isVisit[ny][nx] || map[ny][nx] <= 0) continue

                    q.offer(Pos(nx, ny))
                    isVisit[ny][nx] = true
                }
            }

            max = maxOf(max, cnt)
        }
    }

    println(sum)
    println(max)
}

fun rotate(sx: Int, sy: Int, ex: Int, ey: Int, n: Int, map: Array<IntArray>) {
    for (i in sy..ey) {
        for (j in sx..ex) {
            temp[j - sx][n - 1 - i + sy] = map[i][j]
        }
    }

    for (i in sy..ey) {
        for (j in sx..ex) {
            map[i][j] = temp[i - sy][j - sx]
        }
    }
}