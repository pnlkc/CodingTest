import java.util.StringTokenizer

fun main() {
    val (N, M, L) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N + 2)
    val st = StringTokenizer(readln())
    var r = Int.MAX_VALUE
    var s = 1
    var e = L

    arr[1] = L

    for (i in 2 until N + 2) {
        arr[i] = st.nextToken().toInt()
    }
    
    arr.sort()

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0

        for (i in 0..N) {
            cnt += (arr[i + 1] - arr[i] - 1) / mid
        }

        if (cnt > M) {
            s = mid + 1
        } else {
            r = minOf(r, mid)
            e = mid - 1
        }
    }

    println(r)
}