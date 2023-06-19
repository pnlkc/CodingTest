import java.util.TreeMap

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    repeat(t) {
        val map = TreeMap<Int, Int>()
        val k = readln().toInt()

        repeat(k) {
            val input = readln().split(' ')
            val c = input[0]
            val n = input[1].toInt()
            if (c == "I") {
                if (map[n] == null) map[n] = 1 else map[n] = map[n]!! + 1
            } else {
                if (n == 1 && map.isNotEmpty()) {
                    val max = map.lastKey()
                    if (map[max] == 1) map.remove(max) else map[max] = map[max]!! - 1
                }

                if (n == -1 && map.isNotEmpty()) {
                    val min = map.firstKey()
                    if (map[min] == 1) map.remove(min) else map[min] = map[min]!! - 1
                }
            }
        }

        sb.appendLine(if (map.isEmpty()) "EMPTY" else "${map.lastKey()} ${map.firstKey()}")
    }

    println(sb)
}