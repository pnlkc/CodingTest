fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n * 3) { CharArray(m * 8) }

    for (i in 0 until n * 3) {
        val input = readln()

        for (j in 0 until m * 8) {
            map[i][j] = input[j]
        }
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            val sy = y * 3 + 1
            val sx = x * 8 + 1
            val overTen = map[sy][sx + 5] != '.'
            val r = (map[sy][sx + 4].toString() + if (overTen) map[sy][sx + 5] else "").toInt()

            if (r == map[sy][sx].digitToInt() + map[sy][sx + 2].digitToInt()) {
                for (i in 0..4 + if (overTen) 1 else 0) {
                    map[sy - 1][sx + i] = '*'
                    map[sy + 1][sx + i] = '*'
                }

                map[sy][sx - 1] = '*'
                map[sy][sx + 5 + if (overTen) 1 else 0] = '*'
            } else {
                map[sy - 1][sx + 2] = '/'
                map[sy][sx + 1] = '/'
                map[sy + 1][sx] = '/'
            }
        }
    }

    map.forEach { println(it.joinToString("")) }
}