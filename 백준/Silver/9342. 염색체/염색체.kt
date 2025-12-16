fun main() {
    val sb = StringBuilder()
    val regex = Regex("^[A-F]?A+F+C+[A-F]?$")

    repeat(readln().toInt()) {
        val str = readln()

        sb.appendLine(if (regex.matches(str)) "Infected!" else "Good")
    }

    print(sb)
}