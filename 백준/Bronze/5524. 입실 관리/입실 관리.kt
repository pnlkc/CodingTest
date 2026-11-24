fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    
    for (i in 0 until n) {
        val str = readln()
        
        sb.appendLine(str.lowercase())
    }
    
    print(sb)
}