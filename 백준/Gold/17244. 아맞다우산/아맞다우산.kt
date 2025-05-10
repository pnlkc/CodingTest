import java.util.LinkedList

data class Pos(val x: Int, val y: Int, val bag: Int, val d: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { CharArray(N) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val q = LinkedList<Pos>()
    val isVisit = Array(32) { Array(M) { BooleanArray(N) } }
    var s = Pos(0, 0, 0, 0)
    val itemMap = mutableMapOf<Int, Int>()
    var cnt = 0

    for (i in 0 until M) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]

            if (map[i][j] == 'S') {
                s = Pos(j, i, 0, 0)
                map[i][j] = '.'
            } else if (map[i][j] == 'X') {
                itemMap[i + j * 100] = 1.shl(cnt++)
            }
        }
    }

    q.add(s)
    isVisit[s.bag][s.y][s.x] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
            if (isVisit[c.bag][ny][nx]) continue

            when (map[ny][nx]) {
                '#' -> continue
                'E' -> {
                    if (c.bag.countOneBits() != cnt) continue

                    println(c.d + 1)
                    return
                }
                'X' -> {
                    val nBag = c.bag.or(itemMap[ny + nx * 100]!!)

                    if (isVisit[nBag][ny][nx]) continue

                    isVisit[nBag][ny][nx] = true
                    q.add(Pos(nx, ny, nBag, c.d + 1))
                }
                else -> {
                    isVisit[c.bag][ny][nx] = true
                    q.add(Pos(nx, ny, c.bag, c.d + 1))
                }
            }
        }
    }
}