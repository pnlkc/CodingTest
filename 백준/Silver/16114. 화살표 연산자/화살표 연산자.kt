fun main() {
    val (X, N) = readln().split(" ").map { it.toInt() }

    println(
        when {
            X < 0 -> {
                when {
                    N == 0 -> 0
                    N == 1 -> "INFINITE"
                    N % 2 != 0 -> "ERROR"
                    else -> 0
                }
            }

            X == 0 -> {
                when {
                    N == 0 -> 0
                    N == 1 -> 0
                    N % 2 != 0 -> "ERROR"
                    else -> 0
                }
            }

            else -> {
                when {
                    N == 0 -> "INFINITE"
                    N == 1 -> 0
                    N % 2 != 0 -> "ERROR"
                    else -> X / (N / 2) + if (X % (N / 2) != 0) 0 else -1
                }
            }
        }
    )
}