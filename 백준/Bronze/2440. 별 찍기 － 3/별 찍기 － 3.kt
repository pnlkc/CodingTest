fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    
    for (i in n downTo 1) {
        sb.appendLine("*".repeat(i))
    }
    
    println(sb)
}