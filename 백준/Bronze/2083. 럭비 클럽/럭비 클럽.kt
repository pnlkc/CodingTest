fun main() {
    val sb = StringBuilder()
    while (true) {
        val input = readln()
        if (input == "# 0 0") break
        
        val split = input.split(' ')
        if (split[1].toInt() > 17 || split[2].toInt() >= 80) {
            sb.appendLine(split[0] + " Senior")
        } else {
            sb.appendLine(split[0] + " Junior")
        }
    }
    println(sb)
}