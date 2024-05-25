var min = Int.MAX_VALUE
var max = Int.MIN_VALUE

fun main() {
    val N = readln().toInt()
    val map = Array(N) { CharArray(N) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it[0] }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    dfs(map, 0, 0, map[0][0].digitToInt(), 1, '+')

    println("$max $min")
}

fun dfs(
    map: Array<CharArray>,
    x: Int,
    y: Int,
    num: Int,
    cnt: Int,
    prev: Char
) {
    val N = map.size
    val dx = intArrayOf(1, 0)
    val dy  = intArrayOf(0, 1)

    if (x == N - 1 && y == N - 1) {
        min = minOf(min, num)
        max = maxOf(max, num)
        return
    }

    for (d in 0..1) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (nx >= N || ny >= N) continue

        if (cnt % 2 == 0) {
            var newNum = num

            when (prev) {
                '+' -> newNum += map[ny][nx].digitToInt()
                '-' -> newNum -= map[ny][nx].digitToInt()
                '*' -> newNum *= map[ny][nx].digitToInt()
            }

            dfs(map, nx, ny, newNum, cnt + 1, prev)
        } else {
            dfs(map, nx, ny, num, cnt + 1, map[ny][nx])
        }
    }
}