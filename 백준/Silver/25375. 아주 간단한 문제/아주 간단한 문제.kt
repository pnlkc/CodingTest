fun main() {
    val sb = StringBuilder()
    val Q = readln().toInt()

    for (tc in 1..Q) {
        val (a, b) = readln().split(" ").map { it.toLong() }

        sb.appendLine(if (a < b && b % a == 0L) 1 else 0)
    }

    print(sb)
}