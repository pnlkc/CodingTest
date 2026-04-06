fun main() {
    val n = readln().toInt()
    var max = 0

    repeat(n) {
        val (a, d, g) = readln().split(" ").map { it.toInt() }
        var result = a * (d + g)

        if (a == d + g) result *= 2

        max = maxOf(max, result)
    }

    println(max)
}