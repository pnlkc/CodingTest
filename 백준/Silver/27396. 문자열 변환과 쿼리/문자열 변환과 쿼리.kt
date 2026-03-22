fun main() {
    val sb = StringBuilder()
    val (s, n) = readln().split(" ")
    val map = mutableMapOf<Char, Char>()
    val arr = ('a'..'z').toList().toCharArray() + ('A'..'Z').toList()

    arr.forEach { map[it] = it }

    repeat(n.toInt()) {
        val input = readln().split(" ")

        if (input[0] == "1") {
            val a = input[1][0]
            val b = input[2][0]

            arr.forEach { c -> if (map[c] == a) map[c] = b }
        } else {
            sb.appendLine(s.map { c -> map[c] }.joinToString(""))
        }
    }

    print(sb)
}