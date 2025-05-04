fun main() {
    val N = readln().toInt()
    var num = 0L
    val arr = Array(N) { 0L to 0L }

    for (i in 0 until N) {
        val (x, a) = readln().split(" ").map { it.toLong() }

        arr[i] = x to a
        num += a
    }

    arr.sortBy { it.first }

    val mid = num / 2 + if (num % 2 == 0L) 0 else 1
    var cnt = 0L

    for (i in 0 until N) {
        cnt += arr[i].second

        if (cnt >= mid) {
            println(arr[i].first)
            return
        }
    }
}