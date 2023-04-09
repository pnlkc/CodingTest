fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(k) { readln().toInt() }.also { it.sort() }
    var s = 1L
    var e = arr.last().toLong()

    p@while (s <= e) {
        val mid = (s + e) / 2
        if (arr.sumOf { it / mid } >= n) s = mid + 1 else e = mid - 1
    }

    println(e)
}