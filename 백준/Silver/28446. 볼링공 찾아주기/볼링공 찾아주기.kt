fun main() {
    val sb = StringBuilder()
    val m = readln().toInt()
    val map = mutableMapOf<Int, Int>()

    for (i in 0 until m) {
        val str = readln()

        if (str[0] == '1') {
            val (_, x, w) = str.split(" ").map { it.toInt() }

            map[w] = x
        } else {
            val (_, w) = str.split(" ").map { it.toInt() }

            sb.appendLine(map[w]!!)
        }
    }

    print(sb)
}