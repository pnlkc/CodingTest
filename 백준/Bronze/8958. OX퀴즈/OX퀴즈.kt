fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        val input = readln()
        var r = 0
        var n = 0

        input.forEach { c ->
            if (c == 'O') n++ else n = 0
            r += n
        }
        
        sb.appendLine(r)
    }

    println(sb.toString())
}