fun main() {
    val sb = StringBuilder()
    var bit = 0

    repeat(readln().toInt()) {
        val c = readln().split(" ")

        when (c[0]) {
            "add" -> bit = bit or (1 shl (c[1].toInt() - 1))
            "remove" -> bit = bit and (1 shl (c[1].toInt() - 1)).inv()
            "check" -> sb.append(if (bit and (1 shl (c[1].toInt() - 1)) == 0) "0\n" else "1\n")
            "toggle" -> bit = bit xor (1 shl (c[1].toInt() - 1))
            "all" -> bit = 0b11111111111111111111
            "empty" -> bit = 0
        }
    }

    println(sb.toString())
}