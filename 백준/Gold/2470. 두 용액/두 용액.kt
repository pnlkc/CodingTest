import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val list = List(n) { st.nextToken().toInt() }.sorted()
    var diff = Int.MAX_VALUE
    var min = intArrayOf(0, 0)
    var s = 0
    var e = n - 1

    while (s < e) {
        if (diff > abs(list[s] + list[e])) {
            diff = abs(list[s] + list[e])
            min = intArrayOf(list[s], list[e])
            if (abs(list[s] + list[e]) == 0) return println("${list[s]} ${list[e]}")
        }

        if (list[s] + list[e] < 0) s++ else e--
    }

    println(min.joinToString(" "))
}