fun main() {
    val N = readln().toInt()
    val map = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (k == i || i == j) continue
                if (map[i][k] == 0 || map[k][j] == 0) continue

                if (map[i][k] + map[k][j]  < map[i][j]) {
                    println(-1)
                    return
                }

                if (map[i][k] + map[k][j] == map[i][j]) {
                    map[i][j] = 0
                    map[j][i] = 0
                }
            }
        }
    }
    
    println(map.sumOf { it.sum() } / 2)
}