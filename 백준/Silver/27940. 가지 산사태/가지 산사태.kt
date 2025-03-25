fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val map = IntArray(N + 1)

    for (i in 0 until M) {
        val (t, r) = readln().split(" ").map { it.toInt() }

        map[1] += r

        if (map[1] > K) {
            println("${i + 1} 1")
            return
        }
    }

    println(-1)
}