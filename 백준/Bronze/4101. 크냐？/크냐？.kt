fun main() {
    val sb = StringBuilder()
    
    while (true) {
        val (a, b) = readln().split(' ').map(String::toInt)
        if (a == 0 && b == 0) break
        
        sb.appendLine(if (a > b) "Yes" else "No")
    }
    
    println(sb)
}