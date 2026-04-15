fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()

    repeat (n) {
        val k = readln().toInt()

        repeat(k) {
            sb.append("=")
        }

        sb.appendLine()
    }

    print(sb)
}