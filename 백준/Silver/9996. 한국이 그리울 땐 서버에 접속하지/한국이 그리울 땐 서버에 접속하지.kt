fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val (f, b) = readln().split("*")

    for (i in 1..N) {
        val input = readln()
        val regex = "$f[a-z]*$b".toRegex()

        sb.appendLine(if (regex.matches(input)) "DA" else "NE")
    }

    print(sb)
}