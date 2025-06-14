import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

val dx = intArrayOf(1, 0)
val dy = intArrayOf(0, 1)
val NUM = 1_000_007

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val (x, y) = readln().split(" ").map { it.toInt() - 1 }
    val q = LinkedList<Pos>()
    var dp = Array(h) { IntArray(w) }
    var toast = 0

    q.add(Pos(0, 0))
    dp[0][0] = 1
    calc(q, dp, w, h, x, y, 0, 0)

    toast = dp[y][x]
    q.clear()
    dp = Array(h) { IntArray(w) }
    q.add(Pos(x, y))
    dp[y][x] = toast

    calc(q, dp, w, h, w - 1, h - 1, x, y)

    println(dp[h - 1][w - 1])
}

fun calc(q: LinkedList<Pos>, dp: Array<IntArray>, w: Int, h: Int, tx: Int, ty: Int, sx: Int, sy: Int) {
    while (q.isNotEmpty()) {
        val (cx, cy) = q.poll()!!
        if (cx != sx && cy != sy && dp[cy][cx] != 0) continue

        for (d in 0..1) {
            val addX = cx - dx[d]
            val addY = cy - dy[d]

            if (addX < 0 || addY < 0 || addX >= w || addY >= h) continue
            dp[cy][cx] += dp[addY][addX]
        }

        dp[cy][cx] %= NUM
        if (cx == tx && cy == ty) break

        for (d in 0..1) {
            val nx = cx + dx[d]
            val ny = cy + dy[d]

            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue
            if (dp[ny][nx] != 0) continue

            q.add(Pos(nx, ny))
        }
    }
}