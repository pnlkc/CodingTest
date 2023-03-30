fun readlnSplitToInt() = readln().split(" ").map { it.toInt() }

fun main() {
    val (n, k) = readlnSplitToInt()
    val arr = arrayOf(0) + readlnSplitToInt()
    var max = -10_000_001

    for (i in 1..n) {
        arr[i] += arr[i - 1]
    }

    for (i in k..n) {
        max = maxOf(max, arr[i] - arr[i - k])
    }

    println(max)
}