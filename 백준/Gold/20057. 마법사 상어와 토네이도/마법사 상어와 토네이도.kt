data class Dir(val dx: Int, val dy: Int, val per: Double)

fun main() {
    val N = readln().toInt()
    val map = Array(N) { IntArray(N) }
    val dirArr = initDirArr()
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    var x = N / 2
    var y = N / 2
    var dir = 0
    var num = 1
    var sum = 0

    while (x != 0 || y != 0) {
        for (i in 1..num * 2) {
            val sx = x + dx[dir]
            val sy = y + dy[dir]
            var moveSum = 0

            for (j in 0..8) {
                val (dirX, dirY, dirP) = dirArr[dir][j]
                val nx = sx + dirX
                val ny = sy + dirY
                val sand = (map[sy][sx] * dirP).toInt()

                moveSum += sand

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    sum += sand
                    continue
                }

                map[ny][nx] += sand
            }

            if (sy + dy[dir] in 0 until N && sx + dx[dir] in 0 until N) {
                map[sy + dy[dir]][sx + dx[dir]] += map[sy][sx] - moveSum
            } else {
                sum += map[sy][sx] - moveSum
            }

            map[sy][sx] = 0
            x = sx
            y = sy

            if (x == 0 && y == 0) break
            if (i == num || i == num * 2) dir = (dir + 1) % 4
        }

        num++
    }

    println(sum)
}

fun initDirArr(): Array<Array<Dir>> {
    return arrayOf(
        arrayOf(
            Dir(0, -2, 0.02),
            Dir(-1, -1, 0.1),
            Dir(0, -1, 0.07),
            Dir(1, -1, 0.01),
            Dir(-2, 0, 0.05),
            Dir(-1, 1, 0.1),
            Dir(0, 1, 0.07),
            Dir(1, 1, 0.01),
            Dir(0, 2, 0.02),
        ),
        arrayOf(
            Dir(-2, 0, 0.02),
            Dir(-1, 1, 0.1),
            Dir(-1, 0, 0.07),
            Dir(-1, -1, 0.01),
            Dir(0, 2, 0.05),
            Dir(1, 1, 0.1),
            Dir(1, 0, 0.07),
            Dir(1, -1, 0.01),
            Dir(2, 0, 0.02),
        ),
        arrayOf(
            Dir(0, -2, 0.02),
            Dir(1, -1, 0.1),
            Dir(0, -1, 0.07),
            Dir(-1, -1, 0.01),
            Dir(2, 0, 0.05),
            Dir(1, 1, 0.1),
            Dir(0, 1, 0.07),
            Dir(-1, 1, 0.01),
            Dir(0, 2, 0.02),
        ),
        arrayOf(
            Dir(-2, 0, 0.02),
            Dir(-1, -1, 0.1),
            Dir(-1, 0, 0.07),
            Dir(-1, 1, 0.01),
            Dir(0, -2, 0.05),
            Dir(1, -1, 0.1),
            Dir(1, 0, 0.07),
            Dir(1, 1, 0.01),
            Dir(2, 0, 0.02),
        ),
    )
}