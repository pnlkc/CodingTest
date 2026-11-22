fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..n) {
        sb.appendLine("$i. ${readln()}")
    }
    
    print(sb)
}