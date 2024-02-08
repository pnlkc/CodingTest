fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val M = readln().toInt()
    var l = 1
    var r = list.maxOrNull()!!

    while (l <= r) {
        val mid = (l + r) / 2
        val sum = list.sumOf { if (it > mid) mid else it }

        when {
            sum > M -> r = mid - 1
            sum < M -> l = mid + 1
            else -> break
        }
    }

    println((l + r) / 2)
}