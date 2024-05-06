fun main() {
    val sb = StringBuilder()
    val regex = Regex("(100+1+|01)+")
    val N = readln().toInt()

    for (tc in 1.. N) {
        val input = readln()
        
        sb.appendLine(if (regex.matches(input)) "YES" else "NO")
    }

    print(sb)
}