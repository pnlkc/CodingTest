var N = 0
var M = 0
var map = arrayOf<CharArray>()
var isVisit = arrayOf<BooleanArray>()
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var result = false

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    N = n
    M = m
    map = Array(N) { CharArray(M) }

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            isVisit = Array(N) { BooleanArray(M) }

            dfs(j, i, 1, map[i][j], j, i)
        }
    }

    println(if (result) "Yes" else "No")
}

fun dfs(x: Int, y: Int, cnt: Int, c: Char, sx: Int, sy: Int) {
    if (result) return

    isVisit[y][x] = true

    for (d in 0..3) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
        if (map[ny][nx] != c) continue

        if (nx == sx && ny == sy) {
            if (cnt >= 4) {
                result = true
                return
            }
        }

        if (isVisit[ny][nx]) continue

        dfs(nx, ny, cnt + 1, c, sx, sy)
    }
}