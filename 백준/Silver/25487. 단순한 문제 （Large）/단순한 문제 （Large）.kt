fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    repeat(t) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        sb.appendLine(minOf(a, b, c))
    }

    print(sb)
}