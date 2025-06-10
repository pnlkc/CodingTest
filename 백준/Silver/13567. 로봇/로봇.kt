fun main() {
    val (M, n) = readln().split(" ").map { it.toInt() }
    var x = 0
    var y = 0
    var dir = 0
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    for (tc in 0 until n) {
        val (c, d) = readln().split(" ")

        when (c) {
            "MOVE" -> {
                val nx = x + dx[dir] * d.toInt()
                val ny = y + dy[dir] * d.toInt()

                if (nx < 0 || ny < 0 || nx > M || ny > M) {
                    println(-1)
                    return
                }

                x = nx
                y = ny
            }
            "TURN" -> {
                dir = if (d == "0")  (dir + 1) % 4 else (dir + 3) % 4
            }
        }
    }

    println("$x $y")
}