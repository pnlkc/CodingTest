import java.util.StringTokenizer

fun main() {
    val (n, s) = readln().split(' ').map(String::toInt)
    val st = StringTokenizer(readln())
    val list = List(n) { st.nextToken().toInt() }
    var min = Int.MAX_VALUE
    var sum = list[0]
    var l = 0
    var r = 0

    while (l < n || r < n) {
        if (sum < s) {
            if (r < n) {
                if (++r != n) sum += list[r]
            } else {
                sum -= list[l++]
            }
        } else {
            if (min > r - l + 1) min = r - l + 1
            if (l < n) {
                sum -= list[l++]
            } else {
                if (++r != n) sum += list[r]
            }

        }
    }

    println(if (min == Int.MAX_VALUE) 0 else min)
}