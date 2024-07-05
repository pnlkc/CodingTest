fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val input = readln()
        val map = mutableMapOf<Char, Char>()

        initMap(map, a, b)
        sb.appendLine(input.map { map[it]!! }.joinToString(""))
    }

    print(sb)
}

fun initMap(map: MutableMap<Char, Char>, a: Int, b: Int) {
    for (c in 'A'..'Z') {
        map[c] = ((a * (c - 'A') + b) % 26 + 'A'.code).toChar()
    }
}