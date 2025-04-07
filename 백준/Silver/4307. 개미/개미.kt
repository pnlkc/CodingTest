fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (l, n) = readln().split(" ").map { it.toInt() }
        var min = 0
        var max = 0

        for (i in 1..n) {
            val pos = readln().toInt()

            min = maxOf(min, minOf(l - pos, pos))
            max = maxOf(max, maxOf(l - pos, pos))
        }

        sb.appendLine("$min $max")
    }

    print(sb)
}