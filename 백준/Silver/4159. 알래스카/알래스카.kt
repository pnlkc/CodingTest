fun main() {
    val sb = StringBuilder()

    p@ while (true) {
        val n = readln().toInt()

        if (n == 0) break

        val arr = IntArray(n) { readln().toInt() }

        arr.sort()

        for (i in 1 until n) {
            if (arr[i] - arr[i - 1] > 200) {
                sb.appendLine("IMPOSSIBLE")
                continue@p
            }
        }

        sb.appendLine(if ((1422 - arr.last()) * 2 > 200) "IMPOSSIBLE" else "POSSIBLE")
    }

    print(sb)
}