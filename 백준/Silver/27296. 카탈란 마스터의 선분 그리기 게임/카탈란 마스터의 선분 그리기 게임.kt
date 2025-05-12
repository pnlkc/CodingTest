fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toLong()

        sb.appendLine(if (N <= 1) "1 0" else "0 1")
    }

    print(sb)
}