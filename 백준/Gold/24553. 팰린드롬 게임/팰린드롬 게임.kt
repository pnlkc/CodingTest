fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    repeat(T) {
        val N = readln().toLong()

        sb.appendLine(if (N % 10 == 0L) 1 else 0)
    }

    print(sb)
}