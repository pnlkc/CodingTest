var n = 0
var m = 0
var map = arrayOf<IntArray>()
val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(-1, 0, 1, 0)
val dirMap = mutableMapOf(
    0 to listOf(0, 3, 1),
    1 to listOf(1, 0, 2),
    2 to listOf(2, 1, 3),
    3 to listOf(3, 2, 0),
)
var isVisit = arrayOf<BooleanArray>()
var mx = 0
var my = 0
var mp = 0
var result = 0

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    n = N
    m = M
    map = Array(N) { IntArray(M) }
    isVisit = Array(N) { BooleanArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    val (Y, X, P) = readln().split(" ").map { it.toInt() }

    mx = X
    my = Y
    mp = P
    result = map[my][mx]

    isVisit[my][mx] = true

    for (d in 0..3) {
        val nx = mx + dx[d]
        val ny = my + dy[d]

        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue

        isVisit[ny][nx] = true
        calc(nx, ny, d, 0, map[my][mx])
        isVisit[ny][nx] = false
    }

    println(result)
}

fun calc(x: Int, y: Int, dir: Int, cnt: Int, sum: Int) {
    for (idx in 0..2) {
        val d = dirMap[dir]!![idx]

        if (idx == 0) {
            if (cnt + 1 > mp) return
        } else {
            if (cnt + 2 > mp) return
        }

        val nx = x + dx[d]
        val ny = y + dy[d]

        result = maxOf(result, sum + map[y][x])

        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue
        if (isVisit[ny][nx]) continue

        isVisit[ny][nx] = true
        calc(nx, ny, d, cnt + if (idx == 0) 1 else 2, sum + map[y][x])
        isVisit[ny][nx] = false
    }
}