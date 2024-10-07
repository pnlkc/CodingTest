data class Data(val str: String, val num: Int)

fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) { Data("", 0) }

    for (i in 0 until N) {
        val (str, numStr) = readln().split(" ")
        arr[i] = Data(str, numStr.toInt())
    }

    for (tc in 0 until M) {
        val num = readln().toInt()
        var min = N - 1
        var s = 0
        var e = N - 1

        while (s <= e) {
            val mid = (s + e) / 2

            if (arr[mid].num < num) {
                s = mid + 1
            } else {
                min = minOf(min, mid)
                e = mid - 1
            }
        }

        if (arr[min].num < num) min++
        sb.appendLine(arr[min].str)
    }

    print(sb)
}