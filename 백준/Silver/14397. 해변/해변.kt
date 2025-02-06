fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val dx1 = intArrayOf(-1, 0, 1, 0, -1, -1)
    val dx2 = intArrayOf(0, 1, 1, 1, 0, -1)
    val dy = intArrayOf(-1, -1, 0 , 1, 1, 0)
    var result = 0

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == '#') {
                for (d in 0..5) {
                    val nx = j + if (i % 2 == 0) dx1[d] else dx2[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
                    if (map[ny][nx] == '#') continue

                    result++
                }
            }
        }
    }

    println(result)
}