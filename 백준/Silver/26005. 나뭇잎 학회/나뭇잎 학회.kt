fun main() {
    val N = readln().toInt()

    println(
        when {
            N == 1 -> 0
            N * N % 2 == 0 -> N * N / 2
            else -> N * N / 2 + 1
        }
    )
}