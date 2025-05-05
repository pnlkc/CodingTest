fun main() {
    val sb = StringBuilder()

    while (true) {
        val (_, n) = readlnOrNull()?.let { it.split("/").map { it.toInt() } } ?: break
        var cnt = 0
        var x = n + 1

        while (true) {
            val y = (n * x) / (x - n)

            if ((n * x) % (x - n) == 0 && y >= x) cnt++
            if (y < x) break

            x++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}