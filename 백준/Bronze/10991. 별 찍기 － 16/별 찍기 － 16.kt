fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()

    for (i in 1..n) {
        repeat(n - i) {
            sb.append(" ")
        }

        for (j in 1..i) {
            if (j != 1) sb.append(" ")
            sb.append("*")
        }

        sb.appendLine()
    }

    print(sb)
}