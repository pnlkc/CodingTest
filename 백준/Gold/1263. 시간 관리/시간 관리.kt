fun main() {
    val N = readln().toInt()
    val arr = Array(N) { 0 to 0 }

    for (i in 0 until N) {
        val (T, S) = readln().split(" ").map { it.toInt() }

        arr[i] = T to S
    }

    arr.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    var time = 0
    var result = Int.MAX_VALUE

    for (i in 0 until N) {
        if (time + arr[i].first > arr[i].second) {
            println(-1)
            return
        }

        time += arr[i].first
        result = minOf(result, arr[i].second - time)
    }

    println(result)
}