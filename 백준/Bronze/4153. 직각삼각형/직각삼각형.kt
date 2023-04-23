fun main() {
    val sb = StringBuilder()
    
    while (true) {
        val input = readln()
        if (input == "0 0 0") break
        val (a, b, c) = input.split(" ").map { it.toInt() }.sorted()
        sb.appendLine(if (a * a + b * b != c * c) "wrong" else "right")
    }
    
    println(sb.toString())
}