fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    var result = 0
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until n) {
        val input = readLine()!!.trim().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            arr[i][j] = input[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            var cnt = 0

            for (d in 0..3) {
                val nx = j + dx[d]
                val ny = i + dy[d]

                cnt += when {
                    nx !in 0 until m -> arr[i][j]
                    ny !in 0 until n -> arr[i][j]
                    arr[i][j] > arr[ny][nx] -> arr[i][j] - arr[ny][nx]
                    else -> 0
                }
            }

            result += cnt + 2
        }
    }

    println(result)
}
