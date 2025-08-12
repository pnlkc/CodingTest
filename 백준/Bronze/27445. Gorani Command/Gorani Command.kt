import kotlin.math.abs

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val check = Array(N + 1) { BooleanArray(M + 1) { true } }

    for (r in 1 until N) {
        val dist = readln().toInt()

        for (i in 1..N) {
            for (j in 1..M) {
                if (abs(r - i) + abs(1 - j) != dist) check[i][j] = false
            }
        }
    }

    val dist = readln().split(" ").map { it.toInt() }

    for (c in 1..M) {
        for (i in 1..N) {
            for (j in 1..M) {
                if (abs(N - i) + abs(c - j) != dist[c - 1]) check[i][j] = false
            }
        }
    }

    for (i in 1..N) {
        for (j in 1..M) {
            if (check[i][j]) {
                println("$i $j")
                return
            }
        }
    }
}