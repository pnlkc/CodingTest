import kotlin.math.abs

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val abs = if ((x < 0 && y < 0) || (x > 0 && y > 0)) abs(x + y) else maxOf(abs(x), abs(y))
    var num = 1L
    var step = 1L

    for (i in 0 until abs) {
        num += step
        step += 6
    }

    var nx = 0
    var ny = abs
    val dx = intArrayOf(-1, 0, 1, 1, 0, -1)
    val dy = intArrayOf(0, -1, -1, 0, 1, 1)

    p@ for (d in 0..5) {
        if (nx == x && ny == y) break@p

        for (i in 0 until abs) {
            nx += dx[d]
            ny += dy[d]

            num++

            if (d == 5 && i == 0) {
                num -= abs * 6
            }

            if (nx == x && ny == y) break@p
        }
    }

    println(num)
}