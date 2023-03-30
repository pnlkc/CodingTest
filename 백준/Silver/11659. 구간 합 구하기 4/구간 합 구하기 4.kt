fun readlnSplitToInt() = readln().split(" ").map { it.toInt() }

fun main() {
    val (n, m) = readlnSplitToInt()
    val arr = arrayOf(0) + readlnSplitToInt()
    for (i in 1..n) {
        arr[i] = arr[i - 1] + arr[i]
    }

    repeat(m) {
        val (i, j) = readlnSplitToInt()
        println(arr[j] - arr[i - 1])
    }
}