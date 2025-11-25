fun main() {
    val n = readln().toInt()
    val map = Array(n) { CharArray(n) }
    val dx = intArrayOf(1, 0)
    val dy = intArrayOf(0, 1)
    var max = 1

    for (i in 0 until n) {
        val str = readln()

        for (j in 0 until n) {
            map[i][j] = str[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (d in 0..1) {
                val nx = j + dx[d]
                val ny = i + dy[d]

                if (nx >= n || ny >= n) continue

                val temp = map[i][j]

                map[i][j] = map[ny][nx]
                map[ny][nx] = temp

                var cntA = 1
                var cntB = 1
                var cntC = 1
                var cntD = 1
                var prevA = map[i + dy[d]][0]
                var prevB = map[0][j + dx[d]]
                var prevC = map[i][0]
                var prevD = map[0][j]

                for (k in 1 until n) {
                    if (prevA == map[i + dy[d]][k]) cntA++ else cntA = 1
                    if (prevB == map[k][j + dx[d]]) cntB++ else cntB = 1
                    if (prevC == map[i][k]) cntC++ else cntC = 1
                    if (prevD == map[k][j]) cntD++ else cntD = 1

                    prevA = map[i + dy[d]][k]
                    prevB = map[k][j + dx[d]]
                    prevC = map[i][k]
                    prevD = map[k][j]
                    max = maxOf(max, cntA, cntB, cntC, cntD)
                }

                map[ny][nx] = map[i][j]
                map[i][j] = temp
            }
        }
    }

    println(max)
}