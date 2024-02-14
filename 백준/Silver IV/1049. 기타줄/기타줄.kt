fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    var minSix = Int.MAX_VALUE
    var minOne = Int.MAX_VALUE
    var result = 0

    for (i in 1..M) {
        val (six, one) = readln().split(" ").map { it.toInt() }

        minSix = minOf(minSix, six)
        minOne = minOf(minOne, one)
    }

    result += N / 6 * minOf(minSix, minOne * 6)
    result += minOf(N % 6 * minOne, minSix)

    println(result)
}