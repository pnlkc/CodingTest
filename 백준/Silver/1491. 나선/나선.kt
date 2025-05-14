fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val isVisit = Array(M) { BooleanArray(N) }
    var x = 0
    var y = 0
    var d = 0
    var cnt = 0

    isVisit[y][x] = true

    while (true) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (nx < 0 || ny < 0 || ny >= M || nx >= N || isVisit[ny][nx]) {
            d = (d + 1) % 4
            if (++cnt == 4) break else continue
        }

        x = nx
        y = ny
        cnt = 0
        isVisit[y][x] = true
    }

    println("$x $y")
}