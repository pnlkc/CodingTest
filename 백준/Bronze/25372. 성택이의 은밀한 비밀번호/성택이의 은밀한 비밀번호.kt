fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()

    for (i in 1..N) {
        val input = readln()

        sb.appendLine(if (input.length in 6..9) "yes" else "no")
    }

    print(sb)
}