fun main() {
    val (a1, a0) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    val n0 = readln().toInt()
    val right = c - a1

    println(
        when {
            right < 0 -> 0
            right == 0 -> if (a0 <= 0) 1 else 0
            a0 <= n0 * right -> 1
            else -> 0
        }
    )
}