fun main() {
    val n = readln().toInt()

    println(
        when (n) {
            2 -> 1
            3 -> 3
            else -> 2 * (n - 2) + n
        }
    )
}