fun main() {
    val sb = StringBuilder()

    while (true) {
        val (m, f) = readln().split(" ").map { it.toInt() }

        if (m == 0 && f == 0) break

        sb.appendLine(m + f)
    }
    
    print(sb)
}