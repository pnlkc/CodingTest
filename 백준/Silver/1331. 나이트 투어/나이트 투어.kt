fun main() {
    val map = Array(6) { BooleanArray(6) }
    val dx = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
    val dy = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)

    var sx = 0
    var sy = 0
    var px = 0
    var py = 0

    p@ for (tc in 1..36) {
        val input = readln()
        val x = input[0] - 'A'
        val y = input[1].digitToInt() - 1

        if (tc == 1) {
            sx = x
            px = x
            sy = y
            py = y
        } else {
            for (d in 0..7) {
                val nx = px + dx[d]
                val ny = py + dy[d]

                if (nx < 0 || ny < 0 || nx > 5 || ny > 5) continue
                if (map[ny][nx]) continue

                if (x == nx && y == ny) {
                    map[ny][nx] = true
                    px = nx
                    py = ny
                    continue@p
                }
            }

            println("Invalid")
            return
        }
    }

    for (d in 0..7) {
        val nx = px + dx[d]
        val ny = py + dy[d]

        if (nx < 0 || ny < 0 || nx > 5 || ny > 5) continue
        if (map[ny][nx]) continue

        if (sx == nx && sy == ny) {
            println("Valid")
            return
        }
    }

    println("Invalid")
}