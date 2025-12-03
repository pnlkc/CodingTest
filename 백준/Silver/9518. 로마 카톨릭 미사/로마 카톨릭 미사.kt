fun main() {
    val (r, s) = readln().split(" ").map { it.toInt() }
    val map = Array(r) { CharArray(s) }
    var result = 0
    var add = 0
    val dx = intArrayOf(1, 1, 0, -1, 0, 1, -1, -1)
    val dy = intArrayOf(0, 1, 1, 1, -1, -1, 0, -1)

    for (i in 0 until r) {
        val input = readln()

        for (j in 0 until s) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until r) {
        for (j in 0 until s) {
            var cnt = 0

            for (d in 0..if (map[i][j] == 'o') 3 else 7) {
                val nx = j + dx[d]
                val ny  = i + dy[d]

                if (nx < 0 || ny < 0 || nx >= s || ny >= r) continue

                if (map[ny][nx] == 'o') cnt++
            }

            if (map[i][j] == 'o') result += cnt else add = maxOf(add, cnt)
        }
    }

    println(result + add)
}