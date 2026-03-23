fun main() {
    val (e, em, m, mh, h) = readln().split(" ").map { it.toInt() }
    var start = 0
    var end = 200_000
    var result = 0

    while (start <= end) {
        val mid = (start + end) / 2
        val a = maxOf(0, mid - e)
        val b = maxOf(0, mid - (em - a + m))
        val c = mh - b + h

        if (a <= em && b <= mh && c >= mid) {
            start = mid + 1
            result = maxOf(result, mid)
        } else {
            end = mid - 1
        }
    }

    println(result)
}