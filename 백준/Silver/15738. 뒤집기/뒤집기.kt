fun main() {
    val (N, K, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var result = K

    repeat(M) {
        val command = readln().toInt()

        if (command > 0) {
            if (command >= result) result = command - result + 1
        } else {
            if (N + command < result) result = N - result + 1 + N + command
        }
    }

    println(result)
}