import java.util.StringTokenizer

fun main() {
    var count = 0L
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val list = List(n) { st.nextToken().toInt() }.sorted()
    val x = readln().toLong()
    var s = 0
    var e = n - 1

    while (s < e) {
        when {
            list[s].toLong() + list[e] == x -> {
                count++
                s++
            }
            list[s] + list[e] > x -> e--
            else -> s++
        }
    }

    println(count)
}