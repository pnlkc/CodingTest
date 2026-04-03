fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var result = -1
    var diff = 0

    for (i in 0 until n - 1) {
        val mid = (list[i] + list[i + 1]) / 2
        val min = minOf(mid - list[i], list[i + 1] - mid)

        if (min == 0) continue

        if (diff < min) {
            diff = min
            result = mid
        }
    }

    println(result)
}