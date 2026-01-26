fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    for (tc in 1..t) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }.toIntArray().sortedArray()
        var max = maxOf(list[1] - list[0], list[n - 1] - list[n - 2])

        for (i in 0 until n - 2 step 2) {
            max = maxOf(max, list[i + 2] - list[i])
            if (i + 3 < n) max = maxOf(max, list[i + 3] - list[i + 1])
        }

        sb.appendLine(max)
    }

    print(sb)
}