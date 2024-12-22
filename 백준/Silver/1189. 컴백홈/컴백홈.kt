var r = 0
var c = 0
var k = 0
var map = arrayOf<CharArray>()
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var result = 0

fun main() {
    val (R, C, K) = readln().split(" ").map { it.toInt() }

    map = Array(R) { CharArray(C) }
    r = R
    c = C
    k = K

    for (i in 0 until R) {
        val input = readln()

        for (j in 0 until C) {
            map[i][j] = input[j]
        }
    }

    val isVisit = Array(R) { BooleanArray(C) }

    dfs(0, R - 1, isVisit, 1)
    println(result)
}

fun dfs(x: Int, y: Int, isVisit: Array<BooleanArray>, cnt: Int) {
    if (x == c - 1 && y == 0) {
        if (cnt == k) result++
        return
    }

    isVisit[y][x] = true

    for (d in 0..3) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (nx < 0 || ny < 0 || nx >= c || ny >= r) continue
        if (isVisit[ny][nx] || map[ny][nx] == 'T') continue

        dfs(nx, ny, isVisit, cnt + 1)
    }

    isVisit[y][x] = false
}
