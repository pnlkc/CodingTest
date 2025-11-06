fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val preSum = IntArray(n + 1)

    for (i in 1..n) {
        preSum[i] = preSum[i - 1] + list[i - 1]
    }

    repeat(m) {
        val t = readln().toInt()
        var result = 0
        var s = 1
        var e = n

        while (s <= e) {
            val mid = (s + e) / 2

            if (preSum[mid] <= t) {
                result = mid
                s = mid + 1
            } else {
                e = mid - 1
            }
        }

        sb.appendLine(result)
    }

    print(sb)
}