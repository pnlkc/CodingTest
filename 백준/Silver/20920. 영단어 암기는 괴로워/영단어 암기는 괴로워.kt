fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()

    repeat(n) {
        val input = readln()
        if (input.length >= m) map[input] = 1 + (map[input] ?: 0)
    }

    println(
        map.keys
            .sortedWith(compareByDescending<String> { map[it] }.thenByDescending { it.length }.thenBy { it })
            .joinToString("\n")
    )
}