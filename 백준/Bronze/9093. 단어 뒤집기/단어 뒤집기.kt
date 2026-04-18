fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        sb.appendLine(readln().split(" ").map { it.reversed() }.joinToString(" "))
    }

    print(sb)
}