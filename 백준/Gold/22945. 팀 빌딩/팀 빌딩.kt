import java.util.StringTokenizer

fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    val st = StringTokenizer(readln())

    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    var s = 0
    var e = N - 1
    var max = (N - 2) * minOf(arr[s], arr[e])

    while (s < e) {
        if (arr[s] < arr[e]) s++ else e--
        max = maxOf(max, (e - s - 1) * minOf(arr[s], arr[e]))
    }

    println(max)
}