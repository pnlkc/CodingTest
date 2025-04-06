import java.util.StringTokenizer

fun main() {
    val (N, K) = readln().split(" ").map { it.toLong() }
    val arr = LongArray(N.toInt())
    val st = StringTokenizer(readln())

    for (i in 0 until N.toInt()) {
        arr[i] = st.nextToken().toLong()
    }

    var s = 0L
    var e = 1_000_000_000_000L
    var result = 1_000_000_000_000L

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0L

        for (i in 0 until N.toInt()) {
            if (arr[i] >= mid) cnt += arr[i] - mid
        }

        if (cnt <= K) {
            result = minOf(result, mid)
            e = mid - 1
        } else {
            s = mid + 1
        }
    }

    println(result)
}