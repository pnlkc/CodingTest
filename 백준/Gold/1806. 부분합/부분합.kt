import java.util.StringTokenizer

fun main() {
    val (n, s) = readln().split(' ').map(String::toInt)
    val st = StringTokenizer(readln())
    val list = List(n) { st.nextToken().toInt() }
    var min = Int.MAX_VALUE
    var sum = 0
    var l = 0
    var r = 0

    while (l < n) {
        if (sum < s && r < n) sum += list[r++]
        else sum -= list[l++]

        if (sum >= s) min = minOf(min, r - l)
    }

    println(if (min == Int.MAX_VALUE) 0 else min)
}