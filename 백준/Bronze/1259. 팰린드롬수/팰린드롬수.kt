fun main() {
    val sb = StringBuilder()

    p@while (true) {
        val s = readln()
        if (s == "0") break

        for(i in 0..s.length / 2) {
            if (s[i] != s[s.lastIndex - i]) {
                sb.appendLine("no")
                continue@p
            }
        }

        sb.appendLine("yes")
    }

    println(sb.toString())
}