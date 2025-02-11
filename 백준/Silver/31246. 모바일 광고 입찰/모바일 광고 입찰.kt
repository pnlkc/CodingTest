fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) { 0 to 0 }

    for (i in 0 until N) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        arr[i] = a to b
    }

    arr.sortBy { it.second - it.first }

    var cnt = 0
    var result = 0

    while (cnt < K) {
        if (arr[cnt].first < arr[cnt].second) result = arr[cnt].second - arr[cnt].first
        cnt++
    }

    println(result)
}