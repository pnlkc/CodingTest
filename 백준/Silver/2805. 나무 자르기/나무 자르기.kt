import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    var s = 0L
    var e = 2_000_000_000L

    while (s <= e) {
        val mid = (s + e) / 2
        var sum = 0L

        for (i in 0 until n) {
            sum += maxOf(0, arr[i] - mid)
            if (sum >= m) break
        }

        if (sum >= m) s = mid + 1 else e = mid - 1
    }

    println(e)
}